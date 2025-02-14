package org.youcode.EventLinkerAPI.AnnouncementSkill;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.youcode.EventLinkerAPI.AnnouncementSkill.embeddabales.AnnouncementSkillKey;
import org.youcode.EventLinkerAPI.announcement.Announcement;
import org.youcode.EventLinkerAPI.skill.Skill;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AnnouncementSkill {
    @EmbeddedId
    private AnnouncementSkillKey id;

    @ManyToOne
    @MapsId("announcementId")
    @JoinColumn(name = "announcement_id")
    private Announcement announcement;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private boolean acceptsNonOrganizations;
}
