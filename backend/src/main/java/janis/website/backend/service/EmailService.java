package janis.website.backend.service;

import janis.website.backend.controller.dto.EmailDto;

public interface EmailService {

    void sendEmail(EmailDto emailDto);
}
