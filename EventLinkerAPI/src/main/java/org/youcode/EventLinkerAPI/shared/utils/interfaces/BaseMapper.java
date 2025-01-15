package org.youcode.EventLinkerAPI.shared.utils.interfaces;

public interface BaseMapper<E, CreateDTO, UpdateDTO, ResponseDTO, EmbeddedDTO> {

    E toEntity(CreateDTO createDTO);

    E updateDTOToEntity(UpdateDTO updateDTO);

    ResponseDTO toResponseDTO(E entity);

    EmbeddedDTO toEmbeddedDTO(E entity);

}
