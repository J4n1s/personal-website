package janis.website.backend.service.impl;

import janis.website.backend.controller.dto.EmailDto;
import janis.website.backend.entity.ContactInformation;
import janis.website.backend.service.MailBuilderService;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Service implementation class for building email content related to contact information.
 */
@Service
public class MailBuilderServiceImpl implements MailBuilderService {

  @Override
  public EmailDto buildContactInformationReceivedConfirmation(ContactInformation contactInformation,
                                                              String language) {
    if (language.equals(Locale.ENGLISH.getLanguage())) {
      return new EmailDto(contactInformation.getMail(), "Thanks for getting in touch!", """
                Thank you for getting in touch!
                I will contact you as soon as I can.
                
                Best regards,
                Janis Schneeberger""");
    } else {
      return new EmailDto(contactInformation.getMail(), "Danke für die Kontaktaufnahme!", """
                Danke für die Kontaktaufnahme!
                Ich setze mich sobald ich kann mit Ihnen in Verbindung.
                
                Beste Grüße,
                Janis Schneeberger""");
    }
  }

  @Override
  public EmailDto buildContactInformationNotification(ContactInformation contactInformation) {
    String message = "You received a new contact request from:\n"
        + contactInformation.getName() + "\n"
        + "Mail: " + contactInformation.getMail() + "\n"
        + "Phone: " + contactInformation.getPhone() + "\n" + "\n"
        + "The following message was sent:\n\n"
        + contactInformation.getMessage() + "\n";
    return new EmailDto("janis.schneeberger@outlook.com",
        contactInformation.getName() + " wants to get in touch",
        message);
  }
}
