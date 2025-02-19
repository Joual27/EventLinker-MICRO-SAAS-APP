package org.youcode.EventLinkerAPI.organizer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.EventLinkerAPI.shared.utils.DTOs.SuccessDTO;

@RestController
@RequestMapping("/api/v1/organizer/applications")
public class OrganizerController {


    @PatchMapping("/applications/{action}/{id}")
    public ResponseEntity<SuccessDTO<String>> updateApplicationStatus(@PathVariable("action") String action , @PathVariable("id") Long id){
        return new ResponseEntity<>(new SuccessDTO<>("success" , " Application status updated successfully " , "OHAYO") , HttpStatus.OK);
    }
}
