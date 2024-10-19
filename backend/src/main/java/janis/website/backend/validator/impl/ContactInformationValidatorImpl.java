package janis.website.backend.validator.impl;

import janis.website.backend.entity.ContactInformation;
import janis.website.backend.exception.ValidationException;
import janis.website.backend.validator.ContactInformationValidator;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ContactInformationValidatorImpl implements ContactInformationValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";


    @Override
    public void validate(ContactInformation contactInformation) {
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
}
