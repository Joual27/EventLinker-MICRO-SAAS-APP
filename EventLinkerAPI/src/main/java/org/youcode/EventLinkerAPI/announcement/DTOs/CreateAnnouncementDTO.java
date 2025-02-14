package org.youcode.EventLinkerAPI.announcement.DTOs;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.youcode.EventLinkerAPI.AnnouncementSkill.DTOs.AnnouncementSkillEmbeddedCreationalDTO;

import java.util.List;

public record CreateAnnouncementDTO(@NotNull String title, @NotNull String description , @NotNull @Length(min = 1) List<AnnouncementSkillEmbeddedCreationalDTO> skills , @NotNull Long eventId) {
}
