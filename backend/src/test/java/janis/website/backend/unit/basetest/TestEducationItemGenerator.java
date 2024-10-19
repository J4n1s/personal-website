package janis.website.backend.unit.basetest;

import janis.website.backend.entity.EducationItem;
import janis.website.backend.entity.EducationItemTranslation;

import java.util.List;
import java.util.Locale;

public class TestEducationItemGenerator {

    public static EducationItem generateEducationItem_withSingleTranslation() {
        EducationItem educationItem = new EducationItem(2020, 2023, "url/to/logo");
        educationItem.setTranslations(List.of(generateEducationItemTranslation(educationItem)));
        return educationItem;
    }

    public static EducationItemTranslation generateEducationItemTranslation(EducationItem educationItem) {
        EducationItemTranslation translation = new EducationItemTranslation(Locale.GERMAN.getLanguage(), "Technische Universität Wien",
                "TU Wien", "BSc Software Engineering", "Beschreibung");
        translation.setEducationItem(educationItem);
        return translation;
    }
}
