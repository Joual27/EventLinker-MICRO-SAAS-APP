package org.youcode.EventLinkerAPI.worker.interfaces;

import org.youcode.EventLinkerAPI.worker.DTOs.AddWorkerSkillsDTO;
import org.youcode.EventLinkerAPI.worker.DTOs.UpdateWorkerSkillsDTO;
import org.youcode.EventLinkerAPI.worker.DTOs.WorkerSkillsResponseDTO;
import org.youcode.EventLinkerAPI.worker.Worker;


public interface WorkerService {
    WorkerSkillsResponseDTO addWorkerSKills(AddWorkerSkillsDTO data);
    WorkerSkillsResponseDTO removeWorkerSkill();
    WorkerSkillsResponseDTO updateWorkerSkills(UpdateWorkerSkillsDTO data);
    Worker getWorkerEntityById(Long id);
}
