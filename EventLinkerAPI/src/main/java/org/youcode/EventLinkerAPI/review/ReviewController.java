package org.youcode.EventLinkerAPI.review;


import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.youcode.EventLinkerAPI.review.DTOs.ReviewResponseDTO;
import org.youcode.EventLinkerAPI.review.DTOs.SubmitReviewDTO;
import org.youcode.EventLinkerAPI.review.interfaces.ReviewService;
import org.youcode.EventLinkerAPI.shared.utils.DTOs.SuccessDTO;

@AllArgsConstructor
@RequestMapping("/api/v1/reviews")
@RestController
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public ResponseEntity<SuccessDTO<ReviewResponseDTO>> submitReview(@RequestBody @Valid SubmitReviewDTO req){
        ReviewResponseDTO res = reviewService.submitReview(req);
        return new ResponseEntity<>(new SuccessDTO<>("success" , "review submitted successfully !" , res ), HttpStatus.CREATED);
    }
}
