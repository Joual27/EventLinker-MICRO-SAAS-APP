package org.youcode.EventLinkerAPI.event;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.youcode.EventLinkerAPI.announcement.Announcement;
import org.youcode.EventLinkerAPI.organizer.Organizer;
import org.youcode.EventLinkerAPI.shared.utils.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event extends BaseEntity {
    private String title;
    private String description;
    private LocalDateTime date;
    private String location;
    @ManyToOne
    @JoinColumn(name = "ORGANIZER_ID")
    private Organizer organizer;
    @OneToMany(mappedBy = "event" , fetch = FetchType.EAGER)
    private List<Announcement> announcements;
}
