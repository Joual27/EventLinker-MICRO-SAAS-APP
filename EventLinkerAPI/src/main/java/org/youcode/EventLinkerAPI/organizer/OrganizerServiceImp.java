package org.youcode.EventLinkerAPI.organizer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.application.Application;
import org.youcode.EventLinkerAPI.application.DTOs.ApplicationResponseDTO;
import org.youcode.EventLinkerAPI.application.enums.ApplicationStatus;
import org.youcode.EventLinkerAPI.application.interfaces.ApplicationService;
import org.youcode.EventLinkerAPI.exceptions.EntityNotFoundException;
import org.youcode.EventLinkerAPI.exceptions.UnsupportedActionException;
import org.youcode.EventLinkerAPI.organizer.interfaces.OrganizerService;

@AllArgsConstructor
@Service
public class OrganizerServiceImp implements OrganizerService {
    private final OrganizerDAO organizerDAO;
    private final ApplicationService applicationService;
    @Override
    public Organizer getOrganizerEntityById(Long id) {
        return organizerDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Organizer found with given ID"));
    }

    @Override
    public ApplicationResponseDTO updateApplicationStatus(String action, Long applicationId) {
        Application existingApplication = applicationService.getApplicationEntityById(applicationId);

        return null;
    }

    private Application updateApplicationStatusBasedOnAction(Application application , String action){
        switch (action){
            case "accept" :
                application.setStatus(ApplicationStatus.ACCEPTED);
                return application;
            case "reject" :
                application.setStatus(ApplicationStatus.REFUSED);
                return application;
            default:
                throw new UnsupportedActionException("The given action in URL ain't supported !");
        }
    }

}
