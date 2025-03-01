package org.youcode.EventLinkerAPI.review;

import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.youcode.EventLinkerAPI.application.Application;
import org.youcode.EventLinkerAPI.application.interfaces.ApplicationService;
import org.youcode.EventLinkerAPI.exceptions.InvalidReviewConstraintsException;
import org.youcode.EventLinkerAPI.review.DTOs.ReviewResponseDTO;
import org.youcode.EventLinkerAPI.review.DTOs.SubmitReviewDTO;
import org.youcode.EventLinkerAPI.review.interfaces.ReviewService;
import org.youcode.EventLinkerAPI.review.mapper.ReviewMapper;
import org.youcode.EventLinkerAPI.user.User;
import org.youcode.EventLinkerAPI.user.interfaces.UserService;

@AllArgsConstructor
@Service
public class ReviewServiceImp implements ReviewService {
    private final ReviewDAO reviewDAO;
    private final ReviewMapper reviewMapper;
    private final ApplicationService applicationService;
    private final UserService userService;

    @Override
    public ReviewResponseDTO submitReview(SubmitReviewDTO data){
        Application existingApplication = applicationService.getApplicationEntityById(data.applicationId());
        User reviewer = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User reviewee = userService.getUserEntityById(data.revieweeId());
        validateRolesConstraints(reviewer , reviewee);
        validateApplicationPaymentStatus(existingApplication);
        checkForExistingReview(reviewer , reviewee , existingApplication);
        Review reviewToSubmit = reviewMapper.toEntity(data);
        Review createdReview = reviewDAO.save(reviewToSubmit);
        return reviewMapper.toResponseDTO(createdReview);
    }


    private void validateRolesConstraints(User reviewer , User reviewee){
        String reviewerRole = reviewer.getUserRole();
        String revieweeRole = reviewee.getUserRole();

        if (reviewerRole.equals("ADMIN") || revieweeRole.equals("ADMIN")){
            throw new AccessDeniedException("ADMINS AREN'T CONCERNED BY REVIEWS !");
        }
        if (revieweeRole.equals(revieweeRole)){
            throw new InvalidReviewConstraintsException("Reviewer and reviewee can't have the same role !");
        }
    }

    private void validateApplicationPaymentStatus(Application application){
        if (!application.getPayment().getStatus().equals("succeeded")){
            throw new InvalidReviewConstraintsException("The application should be already payed before giving reviews");
        }
    }

    private void checkForExistingReview(User reviewer , User reviewee , Application application){
        if (reviewDAO.findByReviewerAndRevieweeAndApplication(reviewer , reviewee , application).isPresent()){
            throw new InvalidReviewConstraintsException("You have already gave a review related to this job !");
        }
    }

}
