package janis.website.backend.controller.dto;

import lombok.Data;


/**
 * Data Transfer Object (DTO) for contact information. This class is used to
 * transfer contact-related data between different layers of the application.
 */
@Data
public class ContactInformationDto {

  private String name;
  private String mail;
  private String phone;
  private String message;
}
