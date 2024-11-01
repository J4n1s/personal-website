package janis.website.backend.unit.service;

import janis.website.backend.controller.dto.EmailDto;
import janis.website.backend.service.EmailService;
import janis.website.backend.service.impl.EmailServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DataJpaTest
public class EmailServiceImplTest {

    private final JavaMailSender mailSender = Mockito.mock(JavaMailSender.class);

    private final EmailService emailService = new EmailServiceImpl(mailSender);

    @Test
    void testSendEmail() {
        EmailDto emailDto = new EmailDto("to@example.com", "Confirmation Subject", "Confirmation body");

        emailService.sendEmail(emailDto);

        ArgumentCaptor<SimpleMailMessage> argument = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender, times(1)).send(argument.capture());

        SimpleMailMessage message = argument.getValue();
        assertAll(
                () -> assertEquals(System.getenv("MAIL_FROM"), message.getFrom()),
                () -> assertEquals(emailDto.getRecipient(), Objects.requireNonNull(message.getTo())[0]),
                () -> assertEquals(emailDto.getSubject(), message.getSubject()),
                () -> assertEquals(emailDto.getContent(), message.getText())
        );
    }
}
