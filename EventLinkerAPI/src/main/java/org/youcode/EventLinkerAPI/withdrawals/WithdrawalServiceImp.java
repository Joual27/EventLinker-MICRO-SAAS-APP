package org.youcode.EventLinkerAPI.withdrawals;

import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.ExternalAccount;
import com.stripe.model.Payout;
import com.stripe.param.AccountCreateParams;
import com.stripe.param.PayoutCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.exceptions.InsufficientBalanceException;
import org.youcode.EventLinkerAPI.exceptions.PaymentProcessingException;
import org.youcode.EventLinkerAPI.withdrawals.DTOs.CreateWithdrawalDTO;
import org.youcode.EventLinkerAPI.withdrawals.DTOs.WorkerWithdrawalResponseDTO;
import org.youcode.EventLinkerAPI.withdrawals.enums.WithdrawalStatus;
import org.youcode.EventLinkerAPI.withdrawals.interfaces.WithdrawalService;
import org.youcode.EventLinkerAPI.worker.Worker;
import org.youcode.EventLinkerAPI.worker.interfaces.WorkerService;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class WithdrawalServiceImp implements WithdrawalService {
    private final String defaultCurrency;
    private final WithdrawalDAO withdrawalDAO;
    private final WorkerService workerService;

    public WithdrawalServiceImp(@Value("${DEFAULT_CURRENCY}") String defaultCurrency, WithdrawalDAO withdrawalDAO, WorkerService workerService) {
        this.defaultCurrency = defaultCurrency;
        this.withdrawalDAO = withdrawalDAO;
        this.workerService = workerService;
    }

    @Override
    public WorkerWithdrawalResponseDTO withdraw(CreateWithdrawalDTO data, String payoutMode) {
        Worker worker = (Worker) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (worker.getBalance() < data.amount()) {
            throw new InsufficientBalanceException("The request amount for withdraw is not available on your balance!");
        }
        try {
            verifyStripeAccountOwning(worker);
            Account connectedAccount = Account.retrieve(worker.getStripeAccountId());


            if (!connectedAccount.getPayoutsEnabled()) {
                simulateTestModeVerification(connectedAccount);
                connectedAccount = Account.retrieve(worker.getStripeAccountId());
                System.out.println("Payouts Enabled: " + connectedAccount.getPayoutsEnabled());
                System.out.println("Missing Requirements: " + connectedAccount.getRequirements().getCurrentlyDue());
            }

            Map<String, Object> extParams = new HashMap<>();
            extParams.put("external_account", "btok_us_verified");
            ExternalAccount externalAccount = connectedAccount.getExternalAccounts().create(extParams);

            PayoutCreateParams params = PayoutCreateParams.builder()
                    .setAmount(data.amount())
                    .setCurrency(defaultCurrency)
                    .setDestination(externalAccount.getId())
                    .setMethod(getRequestedPaymentMethod(payoutMode))
                    .build();

            Payout payout = Payout.create(params);
            Withdrawal withdrawalToCreate = new Withdrawal();
            withdrawalToCreate.setAmount((double) data.amount());
            withdrawalToCreate.setRequestedOn(LocalDateTime.now());
            withdrawalToCreate.setStatus(WithdrawalStatus.PROCESSING);
            withdrawalToCreate.setWorker(worker);
            withdrawalToCreate.setStripePayoutId(payout.getId());
            withdrawalDAO.save(withdrawalToCreate);

            return new WorkerWithdrawalResponseDTO(data.amount(), payout.getCurrency(), payout.getStatus(), payoutMode, payout.getType());
        } catch (StripeException e) {
            throw new PaymentProcessingException("Payout failed: " + e.getMessage());
        }
    }



    private PayoutCreateParams.Method getRequestedPaymentMethod(String payoutMode) {
        return payoutMode.equals("instant") ? PayoutCreateParams.Method.INSTANT : PayoutCreateParams.Method.STANDARD;
    }

    private void verifyStripeAccountOwning(Worker worker) {
        try {
            if (worker.getStripeAccountId() == null) {
                AccountCreateParams params = AccountCreateParams.builder()
                        .setType(AccountCreateParams.Type.EXPRESS)
                        .setCountry("US")
                        .setEmail(worker.getEmail())
                        .setBusinessType(AccountCreateParams.BusinessType.INDIVIDUAL)
                        .setIndividual(
                                AccountCreateParams.Individual.builder()
                                        .setFirstName("Test")
                                        .setLastName("User")
                                        .setPhone("+15555555555")
                                        .setIdNumber("000000000")
                                        .setSsnLast4("0000")
                                        .setAddress(
                                                AccountCreateParams.Individual.Address.builder()
                                                        .setLine1("123 Test Street")
                                                        .setCity("San Francisco")
                                                        .setState("CA")
                                                        .setPostalCode("94103")
                                                        .setCountry("US")
                                                        .build()
                                        )
                                        .build()
                        )
                        .build();
                Account account = Account.create(params);
                workerService.updateWorkerStripeId(worker, account.getId());

            }
        } catch (StripeException e) {
            throw new PaymentProcessingException("Account creation failed: " + e.getMessage());
        }
    }

    private void simulateTestModeVerification(Account account) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("business_type", "individual");
        params.put("individual", Map.of(
                "verification", Map.of(
                        "document", Map.of(
                                "front", "file_identity_document_success"
                        )
                )
        ));
        account.update(params);
    }
}