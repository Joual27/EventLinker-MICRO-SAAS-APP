package org.youcode.EventLinkerAPI.announcement;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.AnnouncementSkill.AnnouncementSkill;
import org.youcode.EventLinkerAPI.AnnouncementSkill.DTOs.AnnouncementSkillEmbeddedCreationalDTO;
import org.youcode.EventLinkerAPI.AnnouncementSkill.embeddabales.AnnouncementSkillKey;
import org.youcode.EventLinkerAPI.announcement.DTOs.AnnouncementResponseDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.CreateAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.UpdateAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.enums.AnnouncementStatus;
import org.youcode.EventLinkerAPI.announcement.interfaces.AnnouncementService;
import org.youcode.EventLinkerAPI.announcement.mapper.AnnouncementMapper;
import org.youcode.EventLinkerAPI.event.Event;
import org.youcode.EventLinkerAPI.event.interfaces.EventService;

import org.youcode.EventLinkerAPI.exceptions.EntityNotFoundException;
import org.youcode.EventLinkerAPI.organizer.Organizer;
import org.youcode.EventLinkerAPI.skill.Skill;
import org.youcode.EventLinkerAPI.skill.SkillService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class AnnouncementServiceImp implements AnnouncementService {
    private final AnnouncementDAO announcementDAO;
    private final AnnouncementMapper announcementMapper;
    private final EventService eventService;
    private final SkillService skillService;

    @Transactional
    @Override
    public AnnouncementResponseDTO saveAnnouncement(CreateAnnouncementDTO data) {
        Event existingEvent = eventService.getEventEntityById(data.eventId());
        assertAnnouncementBelongsToOrganizer(existingEvent , "You can Only Create Announcements for your event !");
        Announcement announcementToCreate = announcementMapper.toEntity(data);
        Set<AnnouncementSkill> announcementSkills = validateAndMapAnnouncementSkills(data.skills() , announcementToCreate);
        announcementToCreate.setAnnouncementSkills(announcementSkills);
        announcementToCreate.setEvent(existingEvent);
        announcementToCreate.setCreatedAt(LocalDateTime.now());
        announcementToCreate.setStatus(AnnouncementStatus.PENDING);
        Announcement createdAnnouncement = announcementDAO.save(announcementToCreate);
        return announcementMapper.toResponseDTO(createdAnnouncement);
    }

    @Override
    public AnnouncementResponseDTO updateAnnouncement(UpdateAnnouncementDTO data, Long id) {
        Announcement existingAnnouncement = getAnnouncementEntityById(id);
        existingAnnouncement.getAnnouncementSkills().clear();
        assertAnnouncementBelongsToOrganizer(existingAnnouncement.getEvent() , "You can Only Update Announcements Of your events !");
        Announcement announcementToUpdate = announcementMapper.updateDTOToEntity(data);
        Set<AnnouncementSkill> announcementSkills = validateAndMapAnnouncementSkills(data.skills() , announcementToUpdate);
        announcementToUpdate.setAnnouncementSkills(announcementSkills);
        announcementToUpdate.setId(existingAnnouncement.getId());
        announcementToUpdate.setCreatedAt(existingAnnouncement.getCreatedAt());
        announcementToUpdate.setStatus(existingAnnouncement.getStatus());
        announcementToUpdate.setEvent(existingAnnouncement.getEvent());
        Announcement updatedAnnouncement = announcementDAO.save(announcementToUpdate);
        return announcementMapper.toResponseDTO(updatedAnnouncement);
    }

    @Override
    public AnnouncementResponseDTO getAllAnnouncements(int page, int size) {

        return null;
    }

    @Override
    public AnnouncementResponseDTO getAnnouncementById(Long id) {
        return null;
    }

    @Override
    public AnnouncementResponseDTO deleteAnnouncement(Long id) {
        return null;
    }

    @Override
    public Announcement getAnnouncementEntityById(Long id) {
        return announcementDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Announcement was found with given ID !"));
    }

    private void assertAnnouncementBelongsToOrganizer(Event event , String message){
        Organizer organizer = (Organizer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!organizer.getId().equals(event.getOrganizer().getId())){
            throw new AccessDeniedException(message);
        }
    }

    private Set<AnnouncementSkill> validateAndMapAnnouncementSkills(List<AnnouncementSkillEmbeddedCreationalDTO> skills , Announcement announcement){
        return skills.stream()
                .map(skill -> {
                    Skill existingSkill = skillService.getSkillEntityById(skill.id());
                    AnnouncementSkill announcementSkill = new AnnouncementSkill();
                    AnnouncementSkillKey announcementSkillKey = new AnnouncementSkillKey();
                    announcementSkillKey.setAnnouncementId(announcement.getId());
                    announcementSkillKey.setSkillId(existingSkill.getId());
                    announcementSkill.setId(announcementSkillKey);
                    announcementSkill.setAnnouncement(announcement);
                    announcementSkill.setSkill(existingSkill);
                    announcementSkill.setAcceptsNonOrganizations(skill.acceptsNonOrganizations());
                    return announcementSkill;
                }).collect(Collectors.toSet());
    }


}
