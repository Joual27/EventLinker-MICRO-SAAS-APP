package org.youcode.EventLinkerAPI.review.mapper;

import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.application.DTOs.EmbeddedApplicationDTO;
import org.youcode.EventLinkerAPI.application.mapper.ApplicationMapper;
import org.youcode.EventLinkerAPI.review.DTOs.EmbeddedReviewDTO;
import org.youcode.EventLinkerAPI.review.DTOs.ReviewResponseDTO;
import org.youcode.EventLinkerAPI.review.DTOs.SubmitReviewDTO;
import org.youcode.EventLinkerAPI.review.Review;
import org.youcode.EventLinkerAPI.user.DTOs.EmbeddedUserDTO;
import org.youcode.EventLinkerAPI.user.mapper.UserMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public ReviewResponseDTO toResponseDTO(Review entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String comment = null;
        LocalDateTime createdAt = null;
        EmbeddedApplicationDTO application = null;
        EmbeddedUserDTO reviewer = null;
        EmbeddedUserDTO reviewee = null;

        id = entity.getId();
        comment = entity.getComment();
        createdAt = entity.getCreatedAt();
        application = applicationMapper.toEmbeddedDTO( entity.getApplication() );
        reviewer = userMapper.toEmbeddedDTO( entity.getReviewer() );
        reviewee = userMapper.toEmbeddedDTO( entity.getReviewee() );

        ReviewResponseDTO reviewResponseDTO = new ReviewResponseDTO( id, comment, createdAt, application, reviewer, reviewee );

        return reviewResponseDTO;
    }

    @Override
    public Review toEntity(SubmitReviewDTO createDTO) {
        if ( createDTO == null ) {
            return null;
        }

        Review review = new Review();

        review.setRating( createDTO.rating() );
        review.setComment( createDTO.comment() );

        return review;
    }

    @Override
    public EmbeddedReviewDTO toEmbeddedDTO(Review entity) {
        if ( entity == null ) {
            return null;
        }

        int rating = 0;
        String comment = null;
        EmbeddedUserDTO reviewer = null;
        EmbeddedUserDTO reviewee = null;

        rating = entity.getRating();
        comment = entity.getComment();
        reviewer = userMapper.toEmbeddedDTO( entity.getReviewer() );
        reviewee = userMapper.toEmbeddedDTO( entity.getReviewee() );

        EmbeddedReviewDTO embeddedReviewDTO = new EmbeddedReviewDTO( rating, comment, reviewer, reviewee );

        return embeddedReviewDTO;
    }
}
