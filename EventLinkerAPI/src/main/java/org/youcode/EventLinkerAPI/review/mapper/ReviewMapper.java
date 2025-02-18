package org.youcode.EventLinkerAPI.review.mapper;


import org.mapstruct.Mapper;
import org.youcode.EventLinkerAPI.review.DTOs.EmbeddedReviewDTO;
import org.youcode.EventLinkerAPI.review.Review;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.mappers.BaseEmbeddedMapper;
import org.youcode.EventLinkerAPI.user.mapper.UserMapper;

@Mapper(componentModel = "Spring" , uses = UserMapper.class)
public interface ReviewMapper extends BaseEmbeddedMapper<Review , EmbeddedReviewDTO> {
}
