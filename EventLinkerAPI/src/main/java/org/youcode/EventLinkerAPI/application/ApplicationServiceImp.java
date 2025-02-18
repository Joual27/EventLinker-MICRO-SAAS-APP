package org.youcode.EventLinkerAPI.application;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.application.DTOs.ApplicationResponseDTO;
import org.youcode.EventLinkerAPI.application.DTOs.CreateApplicationDTO;
import org.youcode.EventLinkerAPI.application.DTOs.UpdateApplicationDTO;
import org.youcode.EventLinkerAPI.application.interfaces.ApplicationService;

@AllArgsConstructor
@Service
public class ApplicationServiceImp implements ApplicationService {



    @Override
    public ApplicationResponseDTO saveApplication(CreateApplicationDTO data) {
        return null;
    }

    @Override
    public ApplicationResponseDTO updateApplication(UpdateApplicationDTO data, Long id) {
        return null;
    }

    @Override
    public Page<ApplicationResponseDTO> getAllApplications(int page, int size) {
        return null;
    }

    @Override
    public ApplicationResponseDTO getApplicationById(Long id) {
        return null;
    }

    @Override
    public ApplicationResponseDTO deleteApplication(Long id) {
        return null;
    }
}
