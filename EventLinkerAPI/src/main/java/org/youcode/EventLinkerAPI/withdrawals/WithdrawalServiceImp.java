package org.youcode.EventLinkerAPI.withdrawals;

import com.stripe.exception.StripeException;
import com.stripe.model.Payout;
import com.stripe.param.PayoutCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.exceptions.PaymentProcessingException;
import org.youcode.EventLinkerAPI.withdrawals.DTOs.WorkerWithdrawalResponseDTO;
import org.youcode.EventLinkerAPI.withdrawals.interfaces.WithdrawalService;

@Service
public class WithdrawalServiceImp implements WithdrawalService {
    private final String defaultCurrency ;

    public WithdrawalServiceImp(@Value("${DEFAULT_CURRENCY}") String defaultCurrency){
        this.defaultCurrency = defaultCurrency;
    }

    @Override
    public WorkerWithdrawalResponseDTO withdraw( String cardToken , Long amount , String payoutMode) {
        try{
            PayoutCreateParams params = PayoutCreateParams.builder()
                    .setAmount(amount)
                    .setCurrency(defaultCurrency)
                    .setDestination(cardToken)
                    .setMethod(getRequestedPaymentMethod(payoutMode.toLowerCase()))
                    .build();
            Payout createdPayout =  Payout.create(params);
            return null;
        }catch (StripeException e){
            throw new PaymentProcessingException(e.getMessage());
        }
    }

    private PayoutCreateParams.Method getRequestedPaymentMethod(String payoutMode){
        if (payoutMode.equals("instant")){
            return PayoutCreateParams.Method.INSTANT;
        }
        return PayoutCreateParams.Method.STANDARD;
    }
}
