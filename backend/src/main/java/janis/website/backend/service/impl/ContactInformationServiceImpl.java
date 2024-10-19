package janis.website.backend.service.impl;

import janis.website.backend.controller.dto.EmailDto;
import janis.website.backend.entity.ContactInformation;
import janis.website.backend.repository.ContactInformationRepository;
import janis.website.backend.service.ContactInformationService;
import janis.website.backend.service.EmailService;
import janis.website.backend.service.LanguageService;
import janis.website.backend.service.MailBuilderService;
import janis.website.backend.validator.ContactInformationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactInformationServiceImpl implements ContactInformationService {

    private final ContactInformationRepository contactInformationRepository;
    private final EmailService emailService;
    private final LanguageService languageService;
    private final ContactInformationValidator validator;
    private final MailBuilderService mailBuilderService;

    @Autowired
    public ContactInformationServiceImpl(ContactInformationRepository contactInformationRepository, EmailService emailService, LanguageService languageService, ContactInformationValidator validator, MailBuilderService mailBuilderService) {
        this.contactInformationRepository = contactInformationRepository;
        this.emailService = emailService;
        this.languageService = languageService;
        this.validator = validator;
        this.mailBuilderService = mailBuilderService;
    }

    @Override
    public ContactInformation create(ContactInformation contactInformation) {
        validator.validate(contactInformation);
        emailService.sendEmail(mailBuilderService.buildContactInformationReceivedConfirmation(contactInformation,
                languageService.getLanguage()));
        emailService.sendEmail(mailBuilderService.buildContactInformationNotification(contactInformation));
        return contactInformationRepository.save(contactInformation);
    }
}
