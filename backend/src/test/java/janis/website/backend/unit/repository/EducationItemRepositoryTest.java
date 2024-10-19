package janis.website.backend.unit.repository;

import janis.website.backend.entity.EducationItem;
import janis.website.backend.entity.EducationItemTranslation;
import janis.website.backend.repository.EducationItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EducationItemRepositoryTest {

    private final EducationItemRepository educationItemRepository;
    private EducationItem educationItem;

    @Autowired
    public EducationItemRepositoryTest(EducationItemRepository educationItemRepository) {
        this.educationItemRepository = educationItemRepository;
    }


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
        EducationItemTranslation educationItemTranslation = getEducationItemTranslation();

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

    private EducationItemTranslation getEducationItemTranslation() {
        EducationItemTranslation educationItemTranslation = new EducationItemTranslation();
        educationItemTranslation.setLanguage(Locale.GERMAN.getLanguage());
        educationItemTranslation.setSchoolName("Ballsportgymnasium Wien");
        educationItemTranslation.setSchoolNameAbbreviation("BSG Wien");
        educationItemTranslation.setStudyTitle("Matura");
        educationItemTranslation.setDescription("Schule für Leistungssportler");
        educationItemTranslation.setEducationItem(educationItem);
        return educationItemTranslation;
    }

    @Test
    void testFindOrderedByLanguage() {
        String language = Locale.GERMAN.getLanguage();
        EducationItem educationItem1 = new EducationItem(1980, 1985, "1");
        EducationItem educationItem2 = new EducationItem(1987, null, "3");
        EducationItem educationItem3 = new EducationItem(1982, 1984, "2");
        EducationItem educationItem4 = new EducationItem(1985, 1986, "4");

        EducationItemTranslation educationItemTranslation1 = new EducationItemTranslation(language, "a", "b", "c", "d");
        EducationItemTranslation educationItemTranslation2 = new EducationItemTranslation(language, "e", "f", "g", "h");
        EducationItemTranslation educationItemTranslation3 = new EducationItemTranslation(language, "i", "j", "k", "l");
        EducationItemTranslation educationItemTranslation4 = new EducationItemTranslation("other language", "m", "n", "o", "p");

        educationItemTranslation1.setEducationItem(educationItem1);
        educationItemTranslation2.setEducationItem(educationItem2);
        educationItemTranslation3.setEducationItem(educationItem3);
        educationItemTranslation4.setEducationItem(educationItem4);
        educationItem1.setTranslations(List.of(educationItemTranslation1));
        educationItem2.setTranslations(List.of(educationItemTranslation2));
        educationItem3.setTranslations(List.of(educationItemTranslation3));
        educationItem4.setTranslations(List.of(educationItemTranslation4));

        educationItemRepository.save(educationItem1);
        educationItemRepository.save(educationItem2);
        educationItemRepository.save(educationItem3);
        educationItemRepository.save(educationItem4);

        List<EducationItem> educationItems = educationItemRepository.findAllByLanguageOrderByStartingYear(language);
        assertEquals(3, educationItems.size());
        EducationItem foundEducationItem1 = educationItems.get(0);
        EducationItem foundEducationItem2 = educationItems.get(1);
        EducationItem foundEducationItem3 = educationItems.get(2);

        assertAll(
                () -> assertEquals(educationItem1, foundEducationItem2),
                () -> assertEquals(educationItem2, foundEducationItem1),
                () -> assertEquals(educationItem3, foundEducationItem3)
        );
    }
}
