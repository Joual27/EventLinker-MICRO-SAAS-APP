package org.youcode.EventLinkerAPI.application.DTOs;

import org.youcode.EventLinkerAPI.announcement.DTOs.EmbeddedAnnouncementDTO;
import org.youcode.EventLinkerAPI.application.enums.ApplicationStatus;
import org.youcode.EventLinkerAPI.user.DTOs.EmbeddedUserDTO;

import java.time.LocalDateTime;

public record ApplicationResponseDTO(double price , ApplicationStatus status , LocalDateTime createdAt , String letter , EmbeddedAnnouncementDTO announcement , EmbeddedUserDTO applicant ,  ) {
}
