package janis.website.backend.service.impl;

import janis.website.backend.controller.dto.EmailDto;
import janis.website.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Implementation of the EmailService interface.
 * This service is responsible for sending emails asynchronously.
 * Utilizes JavaMailSender to send emails.
 */
@Service
public class EmailServiceImpl implements EmailService {

  private final JavaMailSender mailSender;

  /**
   * Constructs an EmailServiceImpl with the provided JavaMailSender instance.
   *
   * @param mailSender the JavaMailSender instance used to send emails.
   */
  @Autowired
  public EmailServiceImpl(JavaMailSender mailSender) {
    this.mailSender = mailSender;
  }

  @Async
  @Override
  public void sendEmail(EmailDto emailDto) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("janis.schneeberger@outlook.com");
    message.setTo(emailDto.getRecipient());
    message.setSubject(emailDto.getSubject());
    message.setText(emailDto.getContent());

    mailSender.send(message);
  }
}
