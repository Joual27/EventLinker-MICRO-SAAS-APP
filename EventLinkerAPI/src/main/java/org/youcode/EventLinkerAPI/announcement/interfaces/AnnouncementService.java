package org.youcode.EventLinkerAPI.announcement.interfaces;

import org.youcode.EventLinkerAPI.announcement.DTOs.AnnouncementResponseDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.CreateAnnouncementDTO;

public interface AnnouncementService {
    AnnouncementResponseDTO saveAnnouncement(CreateAnnouncementDTO data);
    AnnouncementResponseDTO updateAnnouncement(CreateAnnouncementDTO data , Long id);
    AnnouncementResponseDTO getAllAnnouncements(int page , int size);
    AnnouncementResponseDTO getAnnouncementById(Long id);
    AnnouncementResponseDTO deleteAnnouncement(Long id);
}