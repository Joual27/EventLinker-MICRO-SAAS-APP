package org.youcode.EventLinkerAPI.DM;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.DM.interfaces.DMService;
import org.youcode.EventLinkerAPI.exceptions.EntityNotFoundException;

@AllArgsConstructor
@Service
public class DMServiceImp implements DMService {

    private final DMDAO dmDao;

    @Override
    public DM getDMEntityById(Long id) {
        return dmDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("NO DM FOUND WITH GIVEN ID ! "));
    }
}
