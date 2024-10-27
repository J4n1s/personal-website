package janis.website.backend.service;

import janis.website.backend.entity.ContactInformation;

/**
 * Service interface for managing contact information.
 * Provides an abstraction layer for operations related to contact information.
 */
public interface ContactInformationService {

  /**
   * Creates a new instance of ContactInformation.
   * This method validates the provided contact information, sends confirmation and notification
   * emails, and persists the contact information into the repository.
   *
   * @param contactInformation the contact information to be created
   * @return the created ContactInformation instance
   */
  ContactInformation create(ContactInformation contactInformation);
}
