package org.youcode.EventLinkerAPI.worker.DTOs;

import jakarta.validation.constraints.NotNull;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.BaseRegistrationDTO;

import java.time.LocalDateTime;

public record WorkerRegistrationDTO(@NotNull String username , @NotNull String password , @NotNull String email , LocalDateTime createdAt , @NotNull boolean isOrganization) implements BaseRegistrationDTO {
}
