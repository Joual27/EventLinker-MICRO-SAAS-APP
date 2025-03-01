package org.youcode.EventLinkerAPI.review.interfaces;

import org.youcode.EventLinkerAPI.review.DTOs.ReviewResponseDTO;
import org.youcode.EventLinkerAPI.review.DTOs.SubmitReviewDTO;

public interface ReviewService {

    ReviewResponseDTO submitReview(SubmitReviewDTO data);
}
