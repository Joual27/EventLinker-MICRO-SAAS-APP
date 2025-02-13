package org.youcode.EventLinkerAPI.event.interfaces;

import org.youcode.EventLinkerAPI.event.DTOs.CreateAndUpdateEventDTO;
import org.youcode.EventLinkerAPI.event.DTOs.EventResponseDTO;

import java.util.List;

public interface EventService {
    EventResponseDTO saveEvent(CreateAndUpdateEventDTO data );
    EventResponseDTO updateEvent(CreateAndUpdateEventDTO data , Long id);
    List<EventResponseDTO> getAllEvents();
    EventResponseDTO getEventById(Long id);
    EventResponseDTO deleteEvent(Long id);
}
