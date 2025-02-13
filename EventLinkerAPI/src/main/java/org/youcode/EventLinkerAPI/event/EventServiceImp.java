package org.youcode.EventLinkerAPI.event;

import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.event.DTOs.CreateEventDTO;
import org.youcode.EventLinkerAPI.event.DTOs.EventResponseDTO;
import org.youcode.EventLinkerAPI.event.DTOs.UpdateEventDTO;
import org.youcode.EventLinkerAPI.event.interfaces.EventService;

import java.util.List;


@Service
public class EventServiceImp implements EventService {
    @Override
    public EventResponseDTO saveEvent(CreateEventDTO data) {
        return null;
    }

    @Override
    public EventResponseDTO updateEvent(UpdateEventDTO data) {
        return null;
    }

    @Override
    public List<EventResponseDTO> getAllEvents() {
        return List.of();
    }

    @Override
    public EventResponseDTO getEventById(Long id) {
        return null;
    }

    @Override
    public EventResponseDTO deleteEvent(Long id) {
        return null;
    }
}
