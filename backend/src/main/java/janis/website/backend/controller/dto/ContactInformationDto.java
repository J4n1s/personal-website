package janis.website.backend.controller.dto;

import lombok.Data;

@Data
public class ContactInformationDto {

    private String name;
    private String mail;
    private String phone;
    private String message;
}
