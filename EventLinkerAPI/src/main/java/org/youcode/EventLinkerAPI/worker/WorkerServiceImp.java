package org.youcode.EventLinkerAPI.worker;

import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.exceptions.EntityNotFoundException;
import org.youcode.EventLinkerAPI.worker.DTOs.AddWorkerSkillsDTO;
import org.youcode.EventLinkerAPI.worker.DTOs.UpdateWorkerSkillsDTO;
import org.youcode.EventLinkerAPI.worker.DTOs.WorkerSkillsResponseDTO;
import org.youcode.EventLinkerAPI.worker.interfaces.WorkerService;

@AllArgsConstructor
@Service
public class WorkerServiceImp implements WorkerService {
    private final WorkerDAO workerDAO;

    @Override
    public WorkerSkillsResponseDTO addWorkerSKills(AddWorkerSkillsDTO data) {
        Worker existingWorker = getWorkerEntityById(data.workerId());
        verifyWorkerIdentity(existingWorker , "You can only update your own skills !");

        return null;
    }

    @Override
    public WorkerSkillsResponseDTO removeWorkerSkill() {
        return null;
    }

    @Override
    public WorkerSkillsResponseDTO updateWorkerSkills(UpdateWorkerSkillsDTO data) {
        return null;
    }

    @Override
    public Worker getWorkerEntityById(Long id) {
        return workerDAO.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("NO WORKER FOUND WITH GIVEN ID !"));
    }

    private void verifyWorkerIdentity(Worker worker ,String message){
        Worker signedInWorker = (Worker) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!worker.getId().equals(signedInWorker.getId())){
            throw new AccessDeniedException(message);
        }
    }
}
