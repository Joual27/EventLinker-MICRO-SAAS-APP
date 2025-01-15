package org.youcode.EventLinkerAPI.user.mapper;

import org.mapstruct.Mapper;
import org.youcode.EventLinkerAPI.organizer.Organizer;
import org.youcode.EventLinkerAPI.worker.Worker;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Organizer toEntity(OrganizerRegistrationDTO dto);
    Worker toEntity(WorkerRegistrationDTO dto);

    OrganizerResponseDTO toResponseDTO(Organizer entity);
    WorkerResponseDTO toResponseDTO(Worker entity);
}
