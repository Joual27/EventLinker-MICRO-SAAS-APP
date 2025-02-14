package org.youcode.EventLinkerAPI.announcement;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.youcode.EventLinkerAPI.AnnouncementSkill.AnnouncementSkill;
import org.youcode.EventLinkerAPI.announcement.enums.AnnouncementStatus;
import org.youcode.EventLinkerAPI.application.Application;
import org.youcode.EventLinkerAPI.event.Event;
import org.youcode.EventLinkerAPI.shared.utils.BaseEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Announcement extends BaseEntity {
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private AnnouncementStatus status;
    @ManyToOne
    @JoinColumn(name = "EVENT_ID")
    private Event event ;
    @OneToMany(mappedBy = "announcement" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Application> applications;

    @OneToMany(fetch = FetchType.EAGER , mappedBy = "announcement" , cascade = CascadeType.ALL)
    private Set<AnnouncementSkill> announcementSkills;
}
