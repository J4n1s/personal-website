package janis.website.backend.unit.mapper;

import janis.website.backend.controller.dto.ContactInformationDto;
import janis.website.backend.controller.mapper.ContactInformationMapper;
import janis.website.backend.controller.mapper.ContactInformationMapperImpl;
import janis.website.backend.entity.ContactInformation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ContactInformationMapperTest {

    private final ContactInformationMapper mapper = new ContactInformationMapperImpl();

    private ContactInformation contactInformation;
    private ContactInformationDto contactInformationDto;

    @BeforeEach
    public void setUp() {
        contactInformation = new ContactInformation();
        contactInformation.setMessage("Test Message");
        contactInformation.setPhone("+4381738571338");
        contactInformation.setName("John Doe");
        contactInformation.setMail("john.doe@example.com");

        contactInformationDto = new ContactInformationDto();
        contactInformationDto.setMessage("Test Message");
        contactInformationDto.setPhone("+4381738571338");
        contactInformationDto.setName("John Doe");
        contactInformationDto.setMail("john.doe@example.com");
    }

    @Test
    void testMapEntityToDto() {
        ContactInformationDto contactInformationDto = mapper.entityToDto(contactInformation);

        assertAll(
                () -> assertEquals(contactInformation.getName(), contactInformationDto.getName()),
                () -> assertEquals(contactInformation.getPhone(), contactInformationDto.getPhone()),
                () -> assertEquals(contactInformation.getMail(), contactInformationDto.getMail()),
                () -> assertEquals(contactInformation.getMessage(), contactInformationDto.getMessage())
        );
    }

    @Test
    void testMapEntityListToDtoList() {
        List<ContactInformationDto> contactInformationDtos = mapper.entityToDto(List.of(contactInformation));
        assertEquals(contactInformationDtos.size(), 1);

        ContactInformationDto contactInformationDto = contactInformationDtos.get(0);
        assertAll(
                () -> assertEquals(contactInformation.getName(), contactInformationDto.getName()),
                () -> assertEquals(contactInformation.getPhone(), contactInformationDto.getPhone()),
                () -> assertEquals(contactInformation.getMail(), contactInformationDto.getMail()),
                () -> assertEquals(contactInformation.getMessage(), contactInformationDto.getMessage())
        );
    }

    @Test
    void testMapEntityListToDtoList_withEmptyList() {
        List<ContactInformationDto> contactInformationDtos = mapper.entityToDto(List.of());
        assertEquals(contactInformationDtos.size(), 0);
    }

    @Test
    void testMapEntityListToDtoList_withListNull() {
        List<ContactInformation> contactInformationList = null;
        List<ContactInformationDto> contactInformationDtos = mapper.entityToDto(contactInformationList);
        assertEquals(contactInformationDtos.size(), 0);
    }

    @Test
    void testMapDtoToEntity() {
        ContactInformation contactInformation = mapper.dtoToEntity(contactInformationDto);
        assertAll(
                () -> assertEquals(contactInformationDto.getName(), contactInformation.getName()),
                () -> assertEquals(contactInformationDto.getPhone(), contactInformation.getPhone()),
                () -> assertEquals(contactInformationDto.getMail(), contactInformation.getMail()),
                () -> assertEquals(contactInformationDto.getMessage(), contactInformation.getMessage())
        );
    }
}
