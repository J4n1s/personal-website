package janis.website.backend.unit.repository;

import janis.website.backend.entity.ContactInformation;
import janis.website.backend.repository.ContactInformationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ContactInformationRepositoryTest {

    @Autowired
    private ContactInformationRepository repository;
    private ContactInformation contact;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();

        contact = new ContactInformation();
        contact.setName("John Doe");
        contact.setMail("john.doe@example.com");
        contact.setPhone("1234567890");
        contact.setMessage("Example message");
    }

    @Test
    void save_singleEntity() {
        repository.save(contact);
        List<ContactInformation> contactInformationList = repository.findAll();

        assertEquals(1, contactInformationList.size());
        ContactInformation foundContactInformation = contactInformationList.get(0);
        assertAll(
                () -> assertEquals(contact.getName(), foundContactInformation.getName()),
                () -> assertEquals(contact.getMail(), foundContactInformation.getMail()),
                () -> assertEquals(contact.getPhone(), foundContactInformation.getPhone()),
                () -> assertEquals(contact.getMessage(), foundContactInformation.getMessage())
        );
    }

    @Test
    void delete_singleEntity() {
        repository.save(contact);
        assertEquals(1, repository.findAll().size());

        repository.delete(contact);
        assertEquals(0, repository.findAll().size());
    }

}
