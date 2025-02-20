package org.youcode.EventLinkerAPI.withdrawals.interfaces;

import org.youcode.EventLinkerAPI.withdrawals.DTOs.WorkerWithdrawalResponseDTO;

public interface WithdrawalService {
    WorkerWithdrawalResponseDTO withdraw( String cardToken , Long amount , String payoutMode);
}
