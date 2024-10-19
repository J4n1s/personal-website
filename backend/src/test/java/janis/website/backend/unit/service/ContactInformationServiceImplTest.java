package janis.website.backend.unit.service;

import janis.website.backend.controller.dto.EmailDto;
import janis.website.backend.entity.ContactInformation;
import janis.website.backend.repository.ContactInformationRepository;
import janis.website.backend.service.EmailService;
import janis.website.backend.service.LanguageService;
import janis.website.backend.service.MailBuilderService;
import janis.website.backend.service.impl.ContactInformationServiceImpl;
import janis.website.backend.validator.ContactInformationValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.mockito.Mockito.*;

@DataJpaTest
public class ContactInformationServiceImplTest {

    private final EmailService emailService = Mockito.mock(EmailService.class);
    private final ContactInformationRepository contactInformationRepository = Mockito.mock(ContactInformationRepository.class);
    private final LanguageService languageService = Mockito.mock(LanguageService.class);
    private final MailBuilderService mailBuilderService = Mockito.mock(MailBuilderService.class);
    private final ContactInformationValidator validator = Mockito.mock(ContactInformationValidator.class);

    private final ContactInformationServiceImpl contactInformationService = new ContactInformationServiceImpl(
            contactInformationRepository, emailService, languageService, validator, mailBuilderService);

    private ContactInformation contact;


    @BeforeEach
    public void setUp() {
        contact = new ContactInformation();
        contact.setName("John Doe");
        contact.setMail("john.doe@example.com");
        contact.setPhone("1234567890");
        contact.setMessage("Example message");

        when(languageService.getLanguage()).thenReturn("en");
    }

    @Test
    void testCreate() {
        EmailDto confirmationEmail = new EmailDto("to@example.com", "Confirmation Subject", "Confirmation body");
        EmailDto notificationEmail = new EmailDto("to@example.com", "Notification Subject", "Notification body");

        when(mailBuilderService.buildContactInformationNotification(contact)).thenReturn(notificationEmail);
        when(mailBuilderService.buildContactInformationReceivedConfirmation(contact, "en")).thenReturn(confirmationEmail);

        contactInformationService.create(contact);
        verify(validator, times(1)).validate(contact);
        verify(emailService, times(1)).sendEmail(confirmationEmail);
        verify(emailService, times(1)).sendEmail(notificationEmail);
        verify(contactInformationRepository, times(1)).save(contact);
    }
}
