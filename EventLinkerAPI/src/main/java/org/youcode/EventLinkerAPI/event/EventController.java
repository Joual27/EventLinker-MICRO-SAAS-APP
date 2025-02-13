package org.youcode.EventLinkerAPI.event;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.EventLinkerAPI.event.DTOs.CreateAndUpdateEventDTO;
import org.youcode.EventLinkerAPI.event.DTOs.EventResponseDTO;
import org.youcode.EventLinkerAPI.event.interfaces.EventService;
import org.youcode.EventLinkerAPI.shared.utils.DTOs.SuccessDTO;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/organizer/events")
public class EventController {
    private final EventService eventService;

    @PostMapping
    public ResponseEntity<SuccessDTO<EventResponseDTO>> createEvent(@RequestBody @Valid CreateAndUpdateEventDTO req){
        EventResponseDTO res = eventService.saveEvent(req);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "event created successfully !" , res) , HttpStatus.CREATED);
    }
}
