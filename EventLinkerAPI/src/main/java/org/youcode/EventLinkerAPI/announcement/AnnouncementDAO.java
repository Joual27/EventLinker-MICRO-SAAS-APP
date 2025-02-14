package org.youcode.EventLinkerAPI.announcement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementDAO extends JpaRepository<Announcement , Long> {
}
