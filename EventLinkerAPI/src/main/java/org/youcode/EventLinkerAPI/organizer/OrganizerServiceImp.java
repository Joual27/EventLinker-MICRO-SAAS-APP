package org.youcode.EventLinkerAPI.organizer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.exceptions.EntityNotFoundException;
import org.youcode.EventLinkerAPI.organizer.interfaces.OrganizerService;

@AllArgsConstructor
@Service
public class OrganizerServiceImp implements OrganizerService {
    private final OrganizerDAO organizerDAO;

    @Override
    public Organizer getOrganizerEntityById(Long id) {
        return organizerDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Organizer found with given ID"));
    }

}
