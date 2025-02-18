package org.youcode.EventLinkerAPI.application;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.youcode.EventLinkerAPI.application.DTOs.ApplicationResponseDTO;
import org.youcode.EventLinkerAPI.application.DTOs.CreateApplicationDTO;
import org.youcode.EventLinkerAPI.application.DTOs.UpdateApplicationDTO;
import org.youcode.EventLinkerAPI.application.interfaces.ApplicationService;
import org.youcode.EventLinkerAPI.shared.utils.DTOs.SuccessDTO;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/worker/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<SuccessDTO<ApplicationResponseDTO>> createApplication(@RequestBody @Valid CreateApplicationDTO req){
        ApplicationResponseDTO res = applicationService.saveApplication(req);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "Application Made Successfully !" , res) , HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessDTO<ApplicationResponseDTO>> updateApplication(@RequestBody @Valid UpdateApplicationDTO req , @PathVariable("id") Long id){
        ApplicationResponseDTO res = applicationService.updateApplication(req , id);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "Application Updated Successfully !" , res) , HttpStatus.OK);
    }

}
