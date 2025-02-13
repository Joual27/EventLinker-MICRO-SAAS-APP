package org.youcode.EventLinkerAPI.event;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.event.DTOs.CreateAndUpdateEventDTO;
import org.youcode.EventLinkerAPI.event.DTOs.EventResponseDTO;
import org.youcode.EventLinkerAPI.event.interfaces.EventService;
import org.youcode.EventLinkerAPI.event.mapper.EventMapper;
import org.youcode.EventLinkerAPI.organizer.Organizer;

import java.time.LocalDateTime;
import java.util.List;



@AllArgsConstructor
@Service
public class EventServiceImp implements EventService {
    private final EventDAO eventDAO;
    private final EventMapper eventMapper;

    @Override
    public EventResponseDTO saveEvent(CreateAndUpdateEventDTO data) {
        if (!isValidDate(data.date())){
            throw new IllegalArgumentException("Event date must be in the future !");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Organizer eventOrganizer = (Organizer) authentication.getPrincipal();
        Event event = eventMapper.toEntity(data);
        event.setOrganizer(eventOrganizer);
        Event createdEvent = eventDAO.save(event);
        return eventMapper.toResponseDTO(createdEvent);
    }

    @Override
    public EventResponseDTO updateEvent(CreateAndUpdateEventDTO data ) {
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

    private boolean isValidDate(LocalDateTime date){
        return date.isAfter(LocalDateTime.now());
    }
}
