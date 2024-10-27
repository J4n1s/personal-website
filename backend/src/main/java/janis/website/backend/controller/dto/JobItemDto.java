package janis.website.backend.controller.dto;

import lombok.Data;


/**
 * Data Transfer Object (DTO) representing a job item with various attributes
 * that capture employment history details.
 */
@Data
public class JobItemDto {

  private Integer startingYear;
  private Integer endingYear;
  private String logoUrl;
  private String employerName;
  private String jobTitle;
  private String jobDescription;

}
