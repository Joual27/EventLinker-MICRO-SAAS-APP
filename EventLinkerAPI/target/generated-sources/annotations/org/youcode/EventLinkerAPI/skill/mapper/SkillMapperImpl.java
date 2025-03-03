package org.youcode.EventLinkerAPI.skill.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.skill.DTOs.EmbeddedSkillDTO;
import org.youcode.EventLinkerAPI.skill.Skill;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class SkillMapperImpl implements SkillMapper {

    @Override
    public EmbeddedSkillDTO toEmbeddedDTO(Skill entity) {
        if ( entity == null ) {
            return null;
        }

        String name = null;

        name = entity.getName();

        EmbeddedSkillDTO embeddedSkillDTO = new EmbeddedSkillDTO( name );

        return embeddedSkillDTO;
    }
}
