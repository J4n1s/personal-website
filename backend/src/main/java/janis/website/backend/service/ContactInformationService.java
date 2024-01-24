package janis.website.backend.service;

import janis.website.backend.entity.ContactInformation;

import java.util.List;

public interface ContactInformationService {

    List<ContactInformation> getAll();

    ContactInformation create(ContactInformation contactInformation);
}
