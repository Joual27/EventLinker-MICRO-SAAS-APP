package org.youcode.EventLinkerAPI.announcement.interfaces;

import org.youcode.EventLinkerAPI.announcement.Announcement;
import org.youcode.EventLinkerAPI.announcement.DTOs.AnnouncementResponseDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.CreateAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.UpdateAnnouncementDTO;

public interface AnnouncementService {
    AnnouncementResponseDTO saveAnnouncement(CreateAnnouncementDTO data);
    AnnouncementResponseDTO updateAnnouncement(UpdateAnnouncementDTO data , Long id);
    AnnouncementResponseDTO getAllAnnouncements(int page , int size);
    AnnouncementResponseDTO getAnnouncementById(Long id);
    AnnouncementResponseDTO deleteAnnouncement(Long id);
    Announcement getAnnouncementEntityById(Long id);
}