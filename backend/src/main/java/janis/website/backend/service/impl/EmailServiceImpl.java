package janis.website.backend.service.impl;

import janis.website.backend.controller.dto.EmailDto;
import janis.website.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final SimpleMailMessage message;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender, SimpleMailMessage message) {
        this.mailSender = mailSender;
        this.message = message;
    }

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
