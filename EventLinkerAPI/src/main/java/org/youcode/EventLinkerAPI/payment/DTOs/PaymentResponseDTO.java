package org.youcode.EventLinkerAPI.payment.DTOs;

import org.youcode.EventLinkerAPI.payment.enums.PaymentStatus;

import java.time.LocalDateTime;

public record PaymentResponseDTO(String clientSecret , String stripePaymentId , double amount , String currency , LocalDateTime processedOn , PaymentStatus status) {
}
