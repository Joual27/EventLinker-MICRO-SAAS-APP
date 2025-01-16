package org.youcode.EventLinkerAPI.organizer.DTOs;

import jakarta.validation.constraints.NotNull;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.BaseRegistrationDTO;

import java.time.LocalDateTime;

public record OrganizerRegistrationDTO(@NotNull String username , @NotNull String password , @NotNull String email , LocalDateTime createdAt , @NotNull String organizationName) implements BaseRegistrationDTO {
}
