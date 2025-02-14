package org.youcode.EventLinkerAPI.announcement;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.EventLinkerAPI.announcement.DTOs.AnnouncementResponseDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.CreateAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.DTOs.UpdateAnnouncementDTO;
import org.youcode.EventLinkerAPI.announcement.interfaces.AnnouncementService;
import org.youcode.EventLinkerAPI.shared.utils.DTOs.SuccessDTO;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/organizer/announcements")
public class AnnouncementController {
    private final AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<SuccessDTO<AnnouncementResponseDTO>> createAnnouncement(@RequestBody @Valid CreateAnnouncementDTO req){
        AnnouncementResponseDTO res = announcementService.saveAnnouncement(req);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "Announcement Created Successfully !" , res) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessDTO<AnnouncementResponseDTO>> updateAnnouncement(@RequestBody @Valid UpdateAnnouncementDTO req , @PathVariable("id") Long id){
        AnnouncementResponseDTO res = announcementService.updateAnnouncement(req , id);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "Announcement Updated Successfully !" , res) , HttpStatus.OK);
    }
}
