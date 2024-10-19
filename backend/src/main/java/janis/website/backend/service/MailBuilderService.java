package janis.website.backend.service;

import janis.website.backend.controller.dto.EmailDto;
import janis.website.backend.entity.ContactInformation;

public interface MailBuilderService {

    EmailDto buildContactInformationReceivedConfirmation(ContactInformation contactInformation, String language);

    EmailDto buildContactInformationNotification(ContactInformation contactInformation);
}
