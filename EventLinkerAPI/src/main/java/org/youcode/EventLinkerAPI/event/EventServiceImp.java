package org.youcode.EventLinkerAPI.event;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.event.DTOs.CreateAndUpdateEventDTO;
import org.youcode.EventLinkerAPI.event.DTOs.EventResponseDTO;
import org.youcode.EventLinkerAPI.event.interfaces.EventService;
import org.youcode.EventLinkerAPI.event.mapper.EventMapper;
import org.youcode.EventLinkerAPI.exceptions.EntityNotFoundException;
import org.youcode.EventLinkerAPI.organizer.Organizer;
import java.time.LocalDateTime;



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
    public EventResponseDTO updateEvent(CreateAndUpdateEventDTO data , Long id) {
        Event eventToUpdate = getEventEntityById(id);
        Organizer eventOrganizer = (Organizer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!eventToUpdate.getOrganizer().getId().equals(eventOrganizer.getId())){
            throw new AccessDeniedException("You Can't Update An Event That Ain't Yours !");
        }
        if (!isValidDate(data.date())){
            throw new IllegalArgumentException("Event date must be in the future !");
        }
        Event event = eventMapper.toEntity(data);
        event.setOrganizer(eventOrganizer);
        event.setId(id);
        Event updatedEvent = eventDAO.save(event);
        return eventMapper.toResponseDTO(updatedEvent);
    }

    @Override
    public Page<EventResponseDTO> getAllEvents(int page , int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Organizer eventOrganizer = (Organizer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Page<Event> events = eventDAO.findByOrganizer_Id( eventOrganizer.getId(), pageRequest);
        return events.map(eventMapper::toResponseDTO);
    }

    @Override
    public EventResponseDTO getEventById(Long id) {
        Organizer eventOrganizer = (Organizer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Event existingEvent = getEventEntityById(id);
        if (!existingEvent.getOrganizer().getId().equals(eventOrganizer.getId())){
            throw new AccessDeniedException("You Can't Get Data Of An Event That Ain't Yours !");
        }
        return eventMapper.toResponseDTO(existingEvent);
    }

    @Override
    public EventResponseDTO deleteEvent(Long id) {
        Organizer eventOrganizer = (Organizer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Event existingEvent = getEventEntityById(id);
        if (!existingEvent.getOrganizer().getId().equals(eventOrganizer.getId())){
            throw new AccessDeniedException("You Can't Get Data Of An Event That Ain't Yours !");
        }
        eventDAO.deleteById(id);
        return eventMapper.toResponseDTO(existingEvent);
    }

    private boolean isValidDate(LocalDateTime date){
        return date.isAfter(LocalDateTime.now());
    }

    private Event getEventEntityById(Long id){
        return eventDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Event Was Found With Given Id !"));
    }
}
