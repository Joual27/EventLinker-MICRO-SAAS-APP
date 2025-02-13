package org.youcode.EventLinkerAPI.AnnouncementSkill.embeddabales;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class AnnouncementSkillKey {
    Long skillId ;
    Long announcementId;
}
