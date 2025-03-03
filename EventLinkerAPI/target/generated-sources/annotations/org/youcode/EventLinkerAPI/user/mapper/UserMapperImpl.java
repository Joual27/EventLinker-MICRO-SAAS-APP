package org.youcode.EventLinkerAPI.user.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.organizer.DTOs.OrganizerRegistrationDTO;
import org.youcode.EventLinkerAPI.organizer.Organizer;
import org.youcode.EventLinkerAPI.user.DTOs.EmbeddedUserDTO;
import org.youcode.EventLinkerAPI.user.User;
import org.youcode.EventLinkerAPI.worker.DTOs.WorkerRegistrationDTO;
import org.youcode.EventLinkerAPI.worker.Worker;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public EmbeddedUserDTO toEmbeddedDTO(User entity) {
        if ( entity == null ) {
            return null;
        }

        String username = null;

        username = entity.getUsername();

        EmbeddedUserDTO embeddedUserDTO = new EmbeddedUserDTO( username );

        return embeddedUserDTO;
    }

    @Override
    public Organizer toEntity(OrganizerRegistrationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Organizer organizer = new Organizer();

        organizer.setUsername( dto.username() );
        organizer.setEmail( dto.email() );
        organizer.setPassword( dto.password() );
        organizer.setCreatedAt( dto.createdAt() );
        organizer.setOrganizationName( dto.organizationName() );

        return organizer;
    }

    @Override
    public Worker toEntity(WorkerRegistrationDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Worker worker = new Worker();

        worker.setUsername( dto.username() );
        worker.setEmail( dto.email() );
        worker.setPassword( dto.password() );
        worker.setCreatedAt( dto.createdAt() );

        return worker;
    }
}
