package org.youcode.EventLinkerAPI.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.youcode.EventLinkerAPI.application.Application;
import org.youcode.EventLinkerAPI.user.User;

import java.util.Optional;

@Repository
public interface ReviewDAO extends JpaRepository<Review , Long> {
    Optional<Review> findByReviewerAndRevieweeAndApplication(User reviewer , User reviwee , Application application);
}
