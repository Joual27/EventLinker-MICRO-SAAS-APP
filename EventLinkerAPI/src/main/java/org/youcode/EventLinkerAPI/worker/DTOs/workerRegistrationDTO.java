package org.youcode.EventLinkerAPI.worker.DTOs;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record workerRegistrationDTO(@NotNull String username , @NotNull String password , @NotNull String email , LocalDateTime createdAt , @NotNull boolean isOrganization) {
}
