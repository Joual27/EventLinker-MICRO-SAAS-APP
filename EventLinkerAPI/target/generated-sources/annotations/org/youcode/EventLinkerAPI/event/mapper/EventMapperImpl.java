package org.youcode.EventLinkerAPI.event.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.event.DTOs.CreateAndUpdateEventDTO;
import org.youcode.EventLinkerAPI.event.DTOs.EmbeddedEventDTO;
import org.youcode.EventLinkerAPI.event.DTOs.EventResponseDTO;
import org.youcode.EventLinkerAPI.event.Event;
import org.youcode.EventLinkerAPI.organizer.DTOs.EmbeddedOrganizerDTO;
import org.youcode.EventLinkerAPI.organizer.Organizer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public EmbeddedEventDTO toEmbeddedDTO(Event entity) {
        if ( entity == null ) {
            return null;
        }

        String title = null;
        String description = null;

        title = entity.getTitle();
        description = entity.getDescription();

        EmbeddedEventDTO embeddedEventDTO = new EmbeddedEventDTO( title, description );

        return embeddedEventDTO;
    }

    @Override
    public Event toEntity(CreateAndUpdateEventDTO createDTO) {
        if ( createDTO == null ) {
            return null;
        }

        Event event = new Event();

        event.setTitle( createDTO.title() );
        event.setDescription( createDTO.description() );
        event.setDate( createDTO.date() );
        event.setLocation( createDTO.location() );

        return event;
    }

    @Override
    public EventResponseDTO toResponseDTO(Event entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String description = null;
        LocalDateTime date = null;
        String location = null;
        EmbeddedOrganizerDTO organizer = null;

        id = entity.getId();
        description = entity.getDescription();
        date = entity.getDate();
        location = entity.getLocation();
        organizer = organizerToEmbeddedOrganizerDTO( entity.getOrganizer() );

        EventResponseDTO eventResponseDTO = new EventResponseDTO( id, description, date, location, organizer );

        return eventResponseDTO;
    }

    protected EmbeddedOrganizerDTO organizerToEmbeddedOrganizerDTO(Organizer organizer) {
        if ( organizer == null ) {
            return null;
        }

        String organizationName = null;

        organizationName = organizer.getOrganizationName();

        EmbeddedOrganizerDTO embeddedOrganizerDTO = new EmbeddedOrganizerDTO( organizationName );

        return embeddedOrganizerDTO;
    }
}
