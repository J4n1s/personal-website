package janis.website.backend.datagenerator;

import jakarta.annotation.PostConstruct;
import janis.website.backend.entity.ContactInformation;
import janis.website.backend.repository.ContactInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.invoke.MethodHandles;

@Profile("generateData")
@Configuration("EducationItemDataGenerator")
public class ContactInformationGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final ContactInformationRepository contactInformationRepository;

    @Autowired
    public ContactInformationGenerator(ContactInformationRepository contactInformationRepository) {
        this.contactInformationRepository = contactInformationRepository;
    }

    @PostConstruct
    private void generateData() {
        if (contactInformationRepository.findAll().isEmpty()) {
            LOGGER.info("Preloading: {}", contactInformationRepository.save(new ContactInformation("Janis",
                    "janis@mail.com", "12345", "Hello")));
            LOGGER.info("Preloading: {}", contactInformationRepository.save(new ContactInformation("Snow-B",
                    "some@mail.com", "+43677", "Hi there")));
        }
    }

}
