package org.youcode.EventLinkerAPI.announcement.mapper;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.AnnouncementSkill.AnnouncementSkill;
import org.youcode.EventLinkerAPI.AnnouncementSkill.DTOs.EmbeddedAnnouncementSkillDTO;
import org.youcode.EventLinkerAPI.announcement.Announcement;
import org.youcode.EventLinkerAPI.announcement.DTOs.AnnouncementResponseDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.CreateAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.EmbeddedAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.UpdateAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.enums.AnnouncementStatus;
import org.youcode.EventLinkerAPI.event.DTOs.EmbeddedEventDTO;
import org.youcode.EventLinkerAPI.event.Event;
import org.youcode.EventLinkerAPI.skill.DTOs.EmbeddedSkillDTO;
import org.youcode.EventLinkerAPI.skill.Skill;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class AnnouncementMapperImpl implements AnnouncementMapper {

    @Override
    public AnnouncementResponseDTO toResponseDTO(Announcement entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String title = null;
        String description = null;
        LocalDateTime createdAt = null;
        AnnouncementStatus status = null;
        EmbeddedEventDTO event = null;
        Set<EmbeddedAnnouncementSkillDTO> announcementSkills = null;

        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        createdAt = entity.getCreatedAt();
        status = entity.getStatus();
        event = eventToEmbeddedEventDTO( entity.getEvent() );
        announcementSkills = announcementSkillSetToEmbeddedAnnouncementSkillDTOSet( entity.getAnnouncementSkills() );

        AnnouncementResponseDTO announcementResponseDTO = new AnnouncementResponseDTO( id, title, description, createdAt, status, event, announcementSkills );

        return announcementResponseDTO;
    }

    @Override
    public Announcement updateDTOToEntity(UpdateAnnouncementDTO updateDTO) {
        if ( updateDTO == null ) {
            return null;
        }

        Announcement announcement = new Announcement();

        announcement.setTitle( updateDTO.title() );
        announcement.setDescription( updateDTO.description() );

        return announcement;
    }

    @Override
    public EmbeddedAnnouncementDTO toEmbeddedDTO(Announcement entity) {
        if ( entity == null ) {
            return null;
        }

        String title = null;
        String description = null;

        title = entity.getTitle();
        description = entity.getDescription();

        EmbeddedAnnouncementDTO embeddedAnnouncementDTO = new EmbeddedAnnouncementDTO( title, description );

        return embeddedAnnouncementDTO;
    }

    @Override
    public Announcement toEntity(CreateAnnouncementDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Announcement announcement = new Announcement();

        announcement.setEvent( createAnnouncementDTOToEvent( dto ) );
        announcement.setTitle( dto.title() );
        announcement.setDescription( dto.description() );

        return announcement;
    }

    protected EmbeddedEventDTO eventToEmbeddedEventDTO(Event event) {
        if ( event == null ) {
            return null;
        }

        String title = null;
        String description = null;

        title = event.getTitle();
        description = event.getDescription();

        EmbeddedEventDTO embeddedEventDTO = new EmbeddedEventDTO( title, description );

        return embeddedEventDTO;
    }

    protected EmbeddedSkillDTO skillToEmbeddedSkillDTO(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        String name = null;

        name = skill.getName();

        EmbeddedSkillDTO embeddedSkillDTO = new EmbeddedSkillDTO( name );

        return embeddedSkillDTO;
    }

    protected EmbeddedAnnouncementSkillDTO announcementSkillToEmbeddedAnnouncementSkillDTO(AnnouncementSkill announcementSkill) {
        if ( announcementSkill == null ) {
            return null;
        }

        EmbeddedAnnouncementDTO announcement = null;
        EmbeddedSkillDTO skill = null;
        boolean acceptsNonOrganizations = false;

        announcement = toEmbeddedDTO( announcementSkill.getAnnouncement() );
        skill = skillToEmbeddedSkillDTO( announcementSkill.getSkill() );
        acceptsNonOrganizations = announcementSkill.isAcceptsNonOrganizations();

        EmbeddedAnnouncementSkillDTO embeddedAnnouncementSkillDTO = new EmbeddedAnnouncementSkillDTO( announcement, skill, acceptsNonOrganizations );

        return embeddedAnnouncementSkillDTO;
    }

    protected Set<EmbeddedAnnouncementSkillDTO> announcementSkillSetToEmbeddedAnnouncementSkillDTOSet(Set<AnnouncementSkill> set) {
        if ( set == null ) {
            return null;
        }

        Set<EmbeddedAnnouncementSkillDTO> set1 = new LinkedHashSet<EmbeddedAnnouncementSkillDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( AnnouncementSkill announcementSkill : set ) {
            set1.add( announcementSkillToEmbeddedAnnouncementSkillDTO( announcementSkill ) );
        }

        return set1;
    }

    protected Event createAnnouncementDTOToEvent(CreateAnnouncementDTO createAnnouncementDTO) {
        if ( createAnnouncementDTO == null ) {
            return null;
        }

        Event event = new Event();

        event.setId( createAnnouncementDTO.eventId() );

        return event;
    }
}
