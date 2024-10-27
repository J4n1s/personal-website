package janis.website.backend.service;

import janis.website.backend.controller.dto.EmailDto;
import janis.website.backend.entity.ContactInformation;

/**
 * Service interface for building email content related to contact information.
 */
public interface MailBuilderService {

  /**
   * Builds an EmailDto for confirming the receipt of contact information.
   *
   * @param contactInformation the contact information received from the user
   * @param language the language to be used for the email content
   * @return an EmailDto containing the confirmation email details
   */
  EmailDto buildContactInformationReceivedConfirmation(ContactInformation contactInformation,
                                                       String language);

  /**
   * Builds an EmailDto containing the notification email details for the provided contact
   * information.
   *
   * @param contactInformation the contact information from which to build the notification email
   * @return an EmailDto with the recipient, subject, and body of the notification email
   */
  EmailDto buildContactInformationNotification(ContactInformation contactInformation);
}
