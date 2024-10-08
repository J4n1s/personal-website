package janis.website.backend.service.impl;

import janis.website.backend.entity.ContactInformation;
import janis.website.backend.repository.ContactInformationRepository;
import janis.website.backend.service.ContactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactInformationServiceImpl implements ContactInformationService {

    private final ContactInformationRepository contactInformationRepository;

    @Autowired
    ContactInformationServiceImpl(ContactInformationRepository contactInformationRepository) {
        this.contactInformationRepository = contactInformationRepository;
    }

    @Override
    public List<ContactInformation> getAll() {
        return contactInformationRepository.findAll();
    }

    @Override
    public ContactInformation create(ContactInformation contactInformation) {
        return contactInformationRepository.save(contactInformation);
    }
}
