package org.youcode.EventLinkerAPI.payment.interfaces;

import com.stripe.model.PaymentIntent;
import org.youcode.EventLinkerAPI.payment.DTOs.ConfirmPaymentIntentDTO;
import org.youcode.EventLinkerAPI.payment.DTOs.CreatePaymentIntentDTO;
import org.youcode.EventLinkerAPI.payment.DTOs.PaymentResponseDTO;

public interface PaymentService {
    PaymentResponseDTO createPaymentIntent(CreatePaymentIntentDTO data);
    PaymentIntent capturePayment(ConfirmPaymentIntentDTO data);

}
