package org.youcode.EventLinkerAPI.AnnouncementSkill.mapper;

import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.AnnouncementSkill.AnnouncementSkill;
import org.youcode.EventLinkerAPI.AnnouncementSkill.DTOs.EmbeddedAnnouncementSkillDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.EmbeddedAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.mapper.AnnouncementMapper;
import org.youcode.EventLinkerAPI.skill.DTOs.EmbeddedSkillDTO;
import org.youcode.EventLinkerAPI.skill.mapper.SkillMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class AnnouncementSkillMapperImpl implements AnnouncementSkillMapper {

    @Autowired
    private AnnouncementMapper announcementMapper;
    @Autowired
    private SkillMapper skillMapper;

    @Override
    public EmbeddedAnnouncementSkillDTO toEmbeddedDTO(AnnouncementSkill entity) {
        if ( entity == null ) {
            return null;
        }

        EmbeddedAnnouncementDTO announcement = null;
        EmbeddedSkillDTO skill = null;
        boolean acceptsNonOrganizations = false;

        announcement = announcementMapper.toEmbeddedDTO( entity.getAnnouncement() );
        skill = skillMapper.toEmbeddedDTO( entity.getSkill() );
        acceptsNonOrganizations = entity.isAcceptsNonOrganizations();

        EmbeddedAnnouncementSkillDTO embeddedAnnouncementSkillDTO = new EmbeddedAnnouncementSkillDTO( announcement, skill, acceptsNonOrganizations );

        return embeddedAnnouncementSkillDTO;
    }
}
