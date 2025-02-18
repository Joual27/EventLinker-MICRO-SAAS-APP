package org.youcode.EventLinkerAPI.review.mapper;


import org.mapstruct.Mapper;
import org.youcode.EventLinkerAPI.review.DTOs.EmbeddedReviewDTO;
import org.youcode.EventLinkerAPI.review.Review;
import org.youcode.EventLinkerAPI.shared.utils.interfaces.mappers.BaseEmbeddedMapper;

@Mapper(componentModel = "Spring")
public interface ReviewMapper extends BaseEmbeddedMapper<Review , EmbeddedReviewDTO> {
}
