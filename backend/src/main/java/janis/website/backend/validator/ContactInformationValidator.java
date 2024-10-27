package janis.website.backend.validator;

import janis.website.backend.entity.ContactInformation;

/**
 * Interface for validating contact information.
 */
public interface ContactInformationValidator {

  /**
   * Validates the given contact information.
   *
   * @param contactInformation the contact information to be validated
   */
  void validate(ContactInformation contactInformation);
}
