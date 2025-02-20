package org.youcode.EventLinkerAPI.worker.DTOs;

public record WorkerWithdrawalResponseDTO(double amount , String currency , String status , String paymentMode , String type) {
}
