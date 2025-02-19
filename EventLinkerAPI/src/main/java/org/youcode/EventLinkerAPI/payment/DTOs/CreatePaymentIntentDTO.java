package org.youcode.EventLinkerAPI.payment.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record CreatePaymentIntentDTO(@NotNull @Min(1) double amount, @NotNull String currency , @NotNull String paymentMethodId , @NotNull Long applicationId) {
}
