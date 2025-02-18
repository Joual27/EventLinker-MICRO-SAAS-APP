package org.youcode.EventLinkerAPI.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationDAO extends JpaRepository<Application , Long> {
}
