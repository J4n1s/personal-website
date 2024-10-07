package janis.website.backend.controller.dto;

import lombok.Data;

@Data
public class EducationItemDto {

    private Integer startingYear;
    private Integer endingYear;
    private String logoUrl;
    private String schoolName;
    private String schoolNameAbbreviation;
    private String studyTitle;
    private String description;

}
