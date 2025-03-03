package org.youcode.EventLinkerAPI.organizer.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.organizer.DTOs.EmbeddedOrganizerDTO;
import org.youcode.EventLinkerAPI.organizer.Organizer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class OrganizerMapperImpl implements OrganizerMapper {

    @Override
    public EmbeddedOrganizerDTO toEmbeddedDTO(Organizer entity) {
        if ( entity == null ) {
            return null;
        }

        String organizationName = null;

        organizationName = entity.getOrganizationName();

        EmbeddedOrganizerDTO embeddedOrganizerDTO = new EmbeddedOrganizerDTO( organizationName );

        return embeddedOrganizerDTO;
    }
}
