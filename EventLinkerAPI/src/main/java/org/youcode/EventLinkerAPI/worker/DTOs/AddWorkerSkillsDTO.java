package org.youcode.EventLinkerAPI.worker.DTOs;

import java.util.List;

public record AddWorkerSkillsDTO(Long workerId , List<EmbeddedWorkerSkillsCreationalDTO> skills) {
}
