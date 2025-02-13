package org.youcode.EventLinkerAPI.event;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return new ResponseEntity<>(new SuccessDTO<>("success" , "Event Created Successfully !" , res) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessDTO<EventResponseDTO>> createEvent(@RequestBody @Valid CreateAndUpdateEventDTO req , @PathVariable("id") Long id){
        EventResponseDTO res = eventService.updateEvent(req , id);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "Event Updated Successfully !" , res) , HttpStatus.OK);
    }

}
