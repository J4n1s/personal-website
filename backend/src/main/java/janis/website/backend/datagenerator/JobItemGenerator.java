package janis.website.backend.datagenerator;

import jakarta.annotation.PostConstruct;
import janis.website.backend.entity.JobItem;
import janis.website.backend.entity.JobItemTranslation;
import janis.website.backend.repository.JobItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

@Configuration("JobItemGenerator")
public class JobItemGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final JobItemRepository jobItemRepository;

    @Autowired
    public JobItemGenerator(JobItemRepository jobItemRepository) {
        this.jobItemRepository = jobItemRepository;
    }

    @PostConstruct
    private void generateData() {
        if (jobItemRepository.count() == 0) {
            LOGGER.info("Saving default job items");

            // APG
            JobItem apg = new JobItem(2021, null, "assets/logo-apg.png");
            List<JobItemTranslation> apgTranslations = getAPGTranslations(apg);
            apg.setTranslations(apgTranslations);
            jobItemRepository.save(apg);

            // MedBits
            JobItem medbits = new JobItem(2023, 2023, "assets/logo-medbits.png");
            List<JobItemTranslation> medbitsTranslations = getMedbitsTranslations(medbits);
            medbits.setTranslations(medbitsTranslations);
            jobItemRepository.save(medbits);

            // Fitinn
            JobItem fitinn = new JobItem(2020, 2021, "assets/logo-fitinn.svg");
            List<JobItemTranslation> fitinnTranslations = getFitinnTranslations(fitinn);
            fitinn.setTranslations(fitinnTranslations);
            jobItemRepository.save(fitinn);
        }
    }

    private static List<JobItemTranslation> getAPGTranslations(JobItem jobItem) {
        JobItemTranslation apgGerman = new JobItemTranslation("de", "APG", "System Administrator",
                "Job Beschreibung");
        JobItemTranslation apgEnglish = new JobItemTranslation("en", "APG", "System Administrator",
                "Job Description");
        apgGerman.setJobItem(jobItem);
        apgEnglish.setJobItem(jobItem);
        List<JobItemTranslation> translations = new ArrayList<>();
        translations.add(apgEnglish);
        translations.add(apgGerman);
        return translations;
    }

    private static List<JobItemTranslation> getMedbitsTranslations(JobItem jobItem) {
        JobItemTranslation medbitsGerman = new JobItemTranslation("de", "medbits", "Software Entwickler",
                "Job Beschreibung");
        JobItemTranslation medbitsEnglish = new JobItemTranslation("en", "medbits", "Software Engineer",
                "Job Description");
        medbitsGerman.setJobItem(jobItem);
        medbitsEnglish.setJobItem(jobItem);
        List<JobItemTranslation> translations = new ArrayList<>();
        translations.add(medbitsGerman);
        translations.add(medbitsEnglish);
        return translations;
    }

    private static List<JobItemTranslation> getFitinnTranslations(JobItem jobItem) {
        JobItemTranslation fitinnGerman = new JobItemTranslation("de", "FitInn", "Rezeptionist",
                "Verkaufsgespräche und Kundenbetreuung");
        JobItemTranslation fitinnEnglish = new JobItemTranslation("en", "FitInn", "Receptionist",
                "Sale of memberships and customer service");
        fitinnGerman.setJobItem(jobItem);
        fitinnEnglish.setJobItem(jobItem);
        List<JobItemTranslation> translations = new ArrayList<>();
        translations.add(fitinnGerman);
        translations.add(fitinnEnglish);
        return translations;
    }
}
