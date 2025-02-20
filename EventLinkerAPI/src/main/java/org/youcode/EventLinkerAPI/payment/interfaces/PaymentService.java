package org.youcode.EventLinkerAPI.payment.interfaces;


import com.stripe.model.Payout;
import org.youcode.EventLinkerAPI.payment.DTOs.CreatePaymentIntentDTO;
import org.youcode.EventLinkerAPI.payment.DTOs.PaymentResponseDTO;

public interface PaymentService {
    PaymentResponseDTO createPaymentIntent(CreatePaymentIntentDTO data);
    Payout createPayout(String cardToken , Long amount , String payoutMode);
}
