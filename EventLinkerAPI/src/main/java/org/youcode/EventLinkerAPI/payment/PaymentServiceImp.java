package org.youcode.EventLinkerAPI.payment;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.exceptions.PaymentProcessingException;
import org.youcode.EventLinkerAPI.payment.DTOs.CreatePaymentIntentDTO;
import org.youcode.EventLinkerAPI.payment.interfaces.PaymentService;


@Service
public class PaymentServiceImp implements PaymentService {
    private final String stripeApiKey;
    private final String defaultCurrency;

    public PaymentServiceImp(@Value("${STRIPE_API_KEY}") String stripeApiKey ,@Value("${DEFAULT_CURRENCY}") String defaultCurrency){
        this.stripeApiKey = stripeApiKey;
        this.defaultCurrency = defaultCurrency;
    }

    @PostConstruct
    public void init(){
        Stripe.apiKey = stripeApiKey;
    }

    @Override
    public PaymentIntent createPaymentIntent(CreatePaymentIntentDTO data) {
        try{
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount((long) data.amount() * 100)
                    .setCurrency(defaultCurrency)
                    .setPaymentMethod(data.paymentMethodId())
                    .setTransferGroup("APPLICATION_"+data.paymentMethodId())
                    .setCaptureMethod(PaymentIntentCreateParams.CaptureMethod.MANUAL)
                    .build();
            return PaymentIntent.create(params);
        }catch (Exception e){
            throw new PaymentProcessingException("Some error occurred while we tried creating an intent !");
        }
    }

    @Override
    public PaymentIntent capturePayment(String paymentIntentId) {
        return null;
    }
}
