package org.youcode.EventLinkerAPI.payment.interfaces;

import com.stripe.model.PaymentIntent;
import org.youcode.EventLinkerAPI.payment.DTOs.CreatePaymentIntentDTO;

public interface PaymentService {
    PaymentIntent createPaymentIntent(CreatePaymentIntentDTO data);
    PaymentIntent capturePayment(String paymentIntentId);

}
