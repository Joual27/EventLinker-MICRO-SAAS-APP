package org.youcode.EventLinkerAPI.DM.interfaces;

import org.youcode.EventLinkerAPI.DM.DM;
import org.youcode.EventLinkerAPI.DM.DTOs.CreateDmDTO;
import org.youcode.EventLinkerAPI.DM.DTOs.DmResponseDTO;

public interface DMService {

    DM getDMEntityById(Long id);
    DmResponseDTO saveDM(CreateDmDTO data);
}
