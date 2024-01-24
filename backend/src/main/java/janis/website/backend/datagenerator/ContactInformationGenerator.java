package janis.website.backend.datagenerator;

import janis.website.backend.entity.ContactInformation;
import janis.website.backend.repository.ContactInformationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.invoke.MethodHandles;

@Configuration
public class ContactInformationGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Bean
    CommandLineRunner initDatabase(ContactInformationRepository repository) {

        return args -> {
            LOGGER.info("Preloading: " + repository.save(new ContactInformation("Janis", "janis@mail.com",
                    "12345", "Hello")));
            LOGGER.info("Preloading: " + repository.save(new ContactInformation("Snow-B", "some@mail.com",
                    "+43677", "Hi there")));
        };
    }

}
