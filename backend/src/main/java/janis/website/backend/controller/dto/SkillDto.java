package janis.website.backend.controller.dto;

import lombok.Data;


/**
 * SkillDto is a data transfer object representing a skill with a name and a level.
 */
@Data
public class SkillDto {
  private String name;
  private int level;
}
