package janis.website.backend.service.impl;

import janis.website.backend.controller.dto.EmailDto;
import janis.website.backend.entity.ContactInformation;
import janis.website.backend.exception.ValidationException;
import janis.website.backend.repository.ContactInformationRepository;
import janis.website.backend.service.ContactInformationService;
import janis.website.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactInformationServiceImpl implements ContactInformationService {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    private final ContactInformationRepository contactInformationRepository;
    private final EmailService emailService;

    @Autowired
    ContactInformationServiceImpl(ContactInformationRepository contactInformationRepository, EmailService emailService) {
        this.contactInformationRepository = contactInformationRepository;
        this.emailService = emailService;
    }

    @Override
    public ContactInformation create(ContactInformation contactInformation) {
        validateContactInformation(contactInformation);
        emailService.sendEmail(getConfirmationEmail(contactInformation));
        emailService.sendEmail(getNotificationEmail(contactInformation));
        return contactInformationRepository.save(contactInformation);
    }

    private void validateContactInformation(ContactInformation contactInformation) {
        if (contactInformation == null) {
            throw new ValidationException("Contact information is null");
        } else {
            if (contactInformation.getName() == null || contactInformation.getName().isEmpty()) {
                throw new ValidationException("Contact information name is empty");
            } else if (contactInformation.getMail() == null || contactInformation.getMail().isEmpty()) {
                throw new ValidationException("Contact information mail is empty");
            } else if (contactInformation.getMessage() == null || contactInformation.getMessage().isEmpty()) {
                throw new ValidationException("Contact information message is empty");
            }
            Pattern pattern = Pattern.compile(EMAIL_REGEX);
            Matcher matcher = pattern.matcher(contactInformation.getMail());
            if (!matcher.matches()) {
                throw new ValidationException("Contact information mail format is incorrect");
            }
        }
    }

    private EmailDto getConfirmationEmail(ContactInformation contactInformation) {
        return new EmailDto(contactInformation.getMail(), "Thanks for getting in touch!", """
                Thank you for getting in touch!
                I will contact you as soon as I can
                
                Best regards,
                Janis Schneeberger""");
    }

    private EmailDto getNotificationEmail(ContactInformation contactInformation) {
        String message = "You received a new contact request from:\n" +
                contactInformation.getName() + "\n" +
                "Mail: " + contactInformation.getMail() + "\n" +
                "Phone: " + contactInformation.getPhone() + "\n" + "\n" +
                "The following message was sent:\n\n" +
                contactInformation.getMessage() + "\n";
        return new EmailDto("janis.schneeberger@outlook.com", contactInformation.getName() + " wants to get in touch",
                message);
    }
}
