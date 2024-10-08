package janis.website.backend.datagenerator;

import jakarta.annotation.PostConstruct;
import janis.website.backend.entity.EducationItem;
import janis.website.backend.entity.EducationItemTranslation;
import janis.website.backend.repository.EducationItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@Configuration("EducationItemDataGenerator")
public class EducationItemDataGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final EducationItemRepository educationItemRepository;

    @Autowired
    public EducationItemDataGenerator(EducationItemRepository educationItemRepository) {
        this.educationItemRepository = educationItemRepository;
    }

    @PostConstruct
    private void generateData() {
        if (educationItemRepository.findAll().isEmpty()) {
            // Med Uni Vienna
            EducationItem medUni = new EducationItem(2024, null, "assets/logo-muw.png");
            List<EducationItemTranslation> medTranslations = getMedUniTranslations(medUni);
            medUni.setTranslations(medTranslations);
            educationItemRepository.save(medUni);
            
            // TU Vienna
            EducationItem tu = new EducationItem(2020, null, "assets/logo-tu.png");
            List<EducationItemTranslation> tuTranslations = getTuTranslations(tu);
            tu.setTranslations(tuTranslations);
            educationItemRepository.save(tu);

            // BSG Vienna
            EducationItem bsg = new EducationItem(2017, 2020, "assets/logo-bsg.svg");
            List<EducationItemTranslation> bsgTranslations = getBSGTranslations(bsg);
            bsg.setTranslations(bsgTranslations);
            educationItemRepository.save(bsg);
        }
    }

    private static List<EducationItemTranslation> getMedUniTranslations(EducationItem educationItem) {
        EducationItemTranslation medGerman = new EducationItemTranslation("de","Medizinische Universität Wien",
                "Med Uni Wien", "Diplomstudium Humanmedizin", "Beschreibung");
        EducationItemTranslation medEnglish = new EducationItemTranslation("en", "Medical University of Vienna",
                "Med Uni Vienna", "Medicine Degree", "Description");
        medGerman.setEducationItem(educationItem);
        medEnglish.setEducationItem(educationItem);
        List<EducationItemTranslation> translations = new ArrayList<>();
        translations.add(medGerman);
        translations.add(medEnglish);
        return translations;
    }

    private static List<EducationItemTranslation> getTuTranslations(EducationItem educationItem) {
        EducationItemTranslation tuGerman = new EducationItemTranslation("de", "Technische Universität Wien",
                "TU Wien", "BSc Software Engineering", "Beschreibung");
        EducationItemTranslation tuEnglish = new EducationItemTranslation("en", "Technical University of Vienna",
                "TU Vienna", "BSc Software Engineering", "Description");
        tuGerman.setEducationItem(educationItem);
        tuEnglish.setEducationItem(educationItem);
        List<EducationItemTranslation> translations = new ArrayList<>();
        translations.add(tuGerman);
        translations.add(tuEnglish);
        return translations;
    }

    private static List<EducationItemTranslation> getBSGTranslations(EducationItem educationItem) {
        EducationItemTranslation bsgGerman = new EducationItemTranslation("de", "Ballsportgymnasium Wien",
                "BSG Wien", "Matura (Ausgezeichneter Erfolg)", "Beschreibung");
        EducationItemTranslation bsgEnglish = new EducationItemTranslation("en", "Ballsportgymnasium Vienna",
                "TU Vienna", "Matura (Excellent success)", "Description");
        bsgGerman.setEducationItem(educationItem);
        bsgEnglish.setEducationItem(educationItem);
        List<EducationItemTranslation> translations = new ArrayList<>();
        translations.add(bsgGerman);
        translations.add(bsgEnglish);
        return translations;
    }
}
