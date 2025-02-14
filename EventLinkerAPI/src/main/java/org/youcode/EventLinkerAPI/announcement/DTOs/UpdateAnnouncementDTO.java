package org.youcode.EventLinkerAPI.announcement.DTOs;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record UpdateAnnouncementDTO(@NotNull String title, @NotNull String description , @NotNull @Length(min = 1) List<Long> skills) {
}
