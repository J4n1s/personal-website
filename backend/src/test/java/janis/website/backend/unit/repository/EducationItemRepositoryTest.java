package janis.website.backend.unit.repository;

import janis.website.backend.entity.EducationItem;
import janis.website.backend.entity.EducationItemTranslation;
import janis.website.backend.repository.EducationItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EducationItemRepositoryTest {

    @Autowired
    private EducationItemRepository educationItemRepository;
    private EducationItem educationItem;

    @BeforeEach
    public void setUp() {
        educationItemRepository.deleteAll();
        educationItem = new EducationItem(2020, null, "url/to/logo");
    }

    @Test
    void testSave() {
        educationItemRepository.save(educationItem);

        List<EducationItem> educationItems = educationItemRepository.findAll();
        assertEquals(1, educationItems.size());
        EducationItem foundEducationItem = educationItems.get(0);
        assertAll(
                () -> assertEquals(educationItem.getStartingYear(), foundEducationItem.getStartingYear()),
                () -> assertEquals(educationItem.getEndingYear(), foundEducationItem.getEndingYear()),
                () -> assertEquals(educationItem.getLogoUrl(), foundEducationItem.getLogoUrl())
        );
    }

    @Test
    void testDelete() {
        educationItemRepository.save(educationItem);
        assertEquals(1, educationItemRepository.findAll().size());

        educationItemRepository.delete(educationItem);
        assertEquals(0, educationItemRepository.findAll().size());
    }

    @Test
    void testSave_withTranslation() {
        EducationItemTranslation educationItemTranslation = new EducationItemTranslation();
        educationItemTranslation.setLanguage("de");
        educationItemTranslation.setSchoolName("Ballsportgymnasium Wien");
        educationItemTranslation.setSchoolNameAbbreviation("BSG Wien");
        educationItemTranslation.setStudyTitle("Matura");
        educationItemTranslation.setDescription("Schule für Leistungssportler");
        educationItemTranslation.setEducationItem(educationItem);

        educationItem.setTranslations(List.of(educationItemTranslation));
        educationItemRepository.save(educationItem);
        List<EducationItem> educationItems = educationItemRepository.findAll();
        assertEquals(1, educationItems.size());
        EducationItem foundEducationItem = educationItems.get(0);
        assertAll(
                () -> assertEquals(1, foundEducationItem.getTranslations().size()),
                () -> assertEquals(educationItemTranslation, foundEducationItem.getTranslations().get(0))
        );
    }
}
