package janis.website.backend.service;

import janis.website.backend.controller.dto.EmailDto;

/**
 * Interface representing an email service responsible for sending emails.
 */
public interface EmailService {

  /**
   * Sends an email based on the provided EmailDto.
   *
   * @param emailDto the Data Transfer Object holding the email details.
   */
  void sendEmail(EmailDto emailDto);
}
