package janis.website.backend.datagenerator;

import jakarta.annotation.PostConstruct;
import janis.website.backend.entity.EducationItem;
import janis.website.backend.entity.EducationItemTranslation;
import janis.website.backend.repository.EducationItemRepository;
import janis.website.backend.service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        if (educationItemRepository.count() == 0) {
            LOGGER.info("Saving default education items");

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
        EducationItemTranslation medGerman = new EducationItemTranslation(Locale.GERMAN.getLanguage(),"Medizinische Universität Wien",
                "Med Uni Wien", "Diplomstudium Humanmedizin", "Nach Abschluss der meisten für " +
                "Informatik relevanten Kurse habe ich das Diplomstudium Humanmedizin angefangen. Ich freue mich dieses Studium anzugehen " +
                "und hoffe mich bereits früh in der medizinschen Forschung einbringen zu können.");
        EducationItemTranslation medEnglish = new EducationItemTranslation(Locale.ENGLISH.getLanguage(), "Medical University of Vienna",
                "Med Uni Vienna", "Medicine Degree", "After finishing most of the relevant " +
                "courses for my Software Engineering studies I'm thrilled to study for my medical degree. I hope that I will be able " +
                "to contribute to medical research at an early stage.");
        medGerman.setEducationItem(educationItem);
        medEnglish.setEducationItem(educationItem);
        List<EducationItemTranslation> translations = new ArrayList<>();
        translations.add(medGerman);
        translations.add(medEnglish);
        return translations;
    }

    private static List<EducationItemTranslation> getTuTranslations(EducationItem educationItem) {
        EducationItemTranslation tuGerman = new EducationItemTranslation(Locale.GERMAN.getLanguage(), "Technische Universität Wien",
                "TU Wien", "BSc Software Engineering", "Direkt nach meiner Matura habe ich mein " +
                "Informatikstudium mit der Vertiefung Software Engineering begonnen. In meiner Zeit auf der TU habe ich viele spannende " +
                "Aspekte der Informatik kennengelernt und benötige nun nur noch meine Abschlussarbeit um das Studium zu beenden.");
        EducationItemTranslation tuEnglish = new EducationItemTranslation(Locale.ENGLISH.getLanguage(), "Technical University of Vienna",
                "TU Vienna", "BSc Software Engineering", "Immediately after graduating from high school, " +
                "I started my degree in computer science with a specialization in software engineering. During my time at TU, I got to know " +
                "many exciting aspects of computer science. To get my degree I only need to finish my final thesis.");
        tuGerman.setEducationItem(educationItem);
        tuEnglish.setEducationItem(educationItem);
        List<EducationItemTranslation> translations = new ArrayList<>();
        translations.add(tuGerman);
        translations.add(tuEnglish);
        return translations;
    }

    private static List<EducationItemTranslation> getBSGTranslations(EducationItem educationItem) {
        EducationItemTranslation bsgGerman = new EducationItemTranslation(Locale.GERMAN.getLanguage(), "Ballsportgymnasium Wien",
                "BSG Wien", "Matura (Ausgezeichneter Erfolg)", "Meine Matura habe ich in einem Gymnasium " +
                "für Leistungssportler absolviert. Neben meiner schulischen Ausbildung habe ich dort American Football bei den Vienna Vikings gespielt.");
        EducationItemTranslation bsgEnglish = new EducationItemTranslation(Locale.ENGLISH.getLanguage(), "Ballsportgymnasium Vienna",
                "TU Vienna", "Matura (Excellent success)", "I went to a special high school for " +
                "competitive athletes. In addition to my school education, I played American Football there for the Vienna Vikings.");
        bsgGerman.setEducationItem(educationItem);
        bsgEnglish.setEducationItem(educationItem);
        List<EducationItemTranslation> translations = new ArrayList<>();
        translations.add(bsgGerman);
        translations.add(bsgEnglish);
        return translations;
    }
}
