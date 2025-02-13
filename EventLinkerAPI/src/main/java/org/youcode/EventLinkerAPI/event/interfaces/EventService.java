package org.youcode.EventLinkerAPI.event.interfaces;

import org.youcode.EventLinkerAPI.event.DTOs.CreateEventDTO;
import org.youcode.EventLinkerAPI.event.DTOs.EventResponseDTO;
import org.youcode.EventLinkerAPI.event.DTOs.UpdateEventDTO;

import java.util.List;

public interface EventService {
    EventResponseDTO saveEvent(CreateEventDTO data);
    EventResponseDTO updateEvent(UpdateEventDTO data);
    List<EventResponseDTO> getAllEvents();
    EventResponseDTO getEventById(Long id);
    EventResponseDTO deleteEvent(Long id);
}
