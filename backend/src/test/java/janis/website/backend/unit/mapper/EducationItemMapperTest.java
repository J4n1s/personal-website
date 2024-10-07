package janis.website.backend.unit.mapper;

import janis.website.backend.controller.dto.EducationItemDto;
import janis.website.backend.controller.mapper.EducationItemMapper;
import janis.website.backend.controller.mapper.EducationItemMapperImpl;
import janis.website.backend.entity.EducationItem;
import janis.website.backend.entity.EducationItemTranslation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static janis.website.backend.unit.basetest.TestEducationItemGenerator.generateEducationItem_withSingleTranslation;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EducationItemMapperTest {

    private final EducationItemMapper mapper = new EducationItemMapperImpl();
    private EducationItem educationItem;

    @BeforeEach
    public void setUp() {
        educationItem = generateEducationItem_withSingleTranslation();
    }

    @Test
    public void testMapEntityToDto() {
        EducationItemDto educationItemDto = mapper.entityToDto(educationItem);
        EducationItemTranslation educationItemTranslation = educationItem.getTranslations().get(0);

        assertAll(
                () -> assertEquals(educationItem.getStartingYear(), educationItemDto.getStartingYear()),
                () -> assertEquals(educationItem.getEndingYear(), educationItemDto.getEndingYear()),
                () -> assertEquals(educationItem.getLogoUrl(), educationItemDto.getLogoUrl()),
                () -> assertEquals(educationItemTranslation.getSchoolName(), educationItemDto.getSchoolName()),
                () -> assertEquals(educationItemTranslation.getSchoolNameAbbreviation(), educationItemDto.getSchoolNameAbbreviation()),
                () -> assertEquals(educationItemTranslation.getStudyTitle(), educationItemDto.getStudyTitle()),
                () -> assertEquals(educationItemTranslation.getDescription(), educationItemDto.getDescription())
        );
    }

    @Test
    public void  testMapEntityListToDtoList() {
        List<EducationItemDto> educationItemDtos = mapper.entityToDto(List.of(educationItem));
        assertEquals(1, educationItemDtos.size());

        EducationItemTranslation educationItemTranslation = educationItem.getTranslations().get(0);
        EducationItemDto educationItemDto = educationItemDtos.get(0);
        assertAll(
                () -> assertEquals(educationItem.getStartingYear(), educationItemDto.getStartingYear()),
                () -> assertEquals(educationItem.getEndingYear(), educationItemDto.getEndingYear()),
                () -> assertEquals(educationItem.getLogoUrl(), educationItemDto.getLogoUrl()),
                () -> assertEquals(educationItemTranslation.getSchoolName(), educationItemDto.getSchoolName()),
                () -> assertEquals(educationItemTranslation.getSchoolNameAbbreviation(), educationItemDto.getSchoolNameAbbreviation()),
                () -> assertEquals(educationItemTranslation.getStudyTitle(), educationItemDto.getStudyTitle()),
                () -> assertEquals(educationItemTranslation.getDescription(), educationItemDto.getDescription())
        );
    }

    @Test
    public void testMapEntityListToDtoList_withEmptyList() {
        List<EducationItemDto> educationItemDtos = mapper.entityToDto(List.of());
        assertEquals(0, educationItemDtos.size());
    }

    @Test
    public void testMapEntityListToDtoList_withListNull() {
        List<EducationItem> educationItems = null;
        List<EducationItemDto> educationItemDtos = mapper.entityToDto(educationItems);
        assertEquals(0, educationItemDtos.size());
    }
}
