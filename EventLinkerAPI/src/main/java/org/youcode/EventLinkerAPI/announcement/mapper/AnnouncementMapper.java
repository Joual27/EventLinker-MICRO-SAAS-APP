package org.youcode.EventLinkerAPI.announcement.mapper;

import org.mapstruct.Mapper;
import org.youcode.EventLinkerAPI.announcement.Announcement;
import org.youcode.EventLinkerAPI.announcement.DTOs.EmbeddedAnnouncementDTO;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.mappers.BaseEmbeddedMapper;

@Mapper(componentModel = "spring")
public interface AnnouncementMapper extends BaseEmbeddedMapper<Announcement , EmbeddedAnnouncementDTO> {
}
