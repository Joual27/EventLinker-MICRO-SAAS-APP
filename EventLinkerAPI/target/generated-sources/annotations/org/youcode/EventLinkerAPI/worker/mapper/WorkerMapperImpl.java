package org.youcode.EventLinkerAPI.worker.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.skill.DTOs.EmbeddedSkillDTO;
import org.youcode.EventLinkerAPI.skill.Skill;
import org.youcode.EventLinkerAPI.user.DTOs.EmbeddedUserDTO;
import org.youcode.EventLinkerAPI.worker.DTOs.WorkerSkillsResponseDTO;
import org.youcode.EventLinkerAPI.worker.Worker;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class WorkerMapperImpl implements WorkerMapper {

    @Override
    public EmbeddedUserDTO toEmbeddedDTO(Worker entity) {
        if ( entity == null ) {
            return null;
        }

        String username = null;

        username = entity.getUsername();

        EmbeddedUserDTO embeddedUserDTO = new EmbeddedUserDTO( username );

        return embeddedUserDTO;
    }

    @Override
    public WorkerSkillsResponseDTO toResponseDTO(Worker entity) {
        if ( entity == null ) {
            return null;
        }

        String username = null;
        String email = null;
        double balance = 0.0d;
        List<EmbeddedSkillDTO> skills = null;

        username = entity.getUsername();
        email = entity.getEmail();
        balance = entity.getBalance();
        skills = skillListToEmbeddedSkillDTOList( entity.getSkills() );

        boolean isOrganization = false;

        WorkerSkillsResponseDTO workerSkillsResponseDTO = new WorkerSkillsResponseDTO( username, email, isOrganization, balance, skills );

        return workerSkillsResponseDTO;
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

    protected List<EmbeddedSkillDTO> skillListToEmbeddedSkillDTOList(List<Skill> list) {
        if ( list == null ) {
            return null;
        }

        List<EmbeddedSkillDTO> list1 = new ArrayList<EmbeddedSkillDTO>( list.size() );
        for ( Skill skill : list ) {
            list1.add( skillToEmbeddedSkillDTO( skill ) );
        }

        return list1;
    }
}
