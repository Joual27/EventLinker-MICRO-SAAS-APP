package org.youcode.EventLinkerAPI.worker.mapper;

import org.mapstruct.Mapper;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.mappers.BaseResponseMapper;
import org.youcode.EventLinkerAPI.worker.DTOs.WorkerSkillsResponseDTO;
import org.youcode.EventLinkerAPI.worker.Worker;

@Mapper(componentModel = "spring")
public interface WorkerMapper extends BaseResponseMapper<Worker, WorkerSkillsResponseDTO> {
}
