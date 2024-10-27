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
import java.util.Locale;

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
    JobItemTranslation apgGerman = new JobItemTranslation(Locale.GERMAN.getLanguage(), "APG", "System Administrator",
        "Bei der APG bin ich mit der Überwachung und Instandhaltung des zentralen Netzführungssystems " +
            "betraut. Dabei handelt es sich um ein verteiltes Echtzeitsystem zur Steuerung des österreichischen " +
            "Stromnetzes. Meine Hauptaufgabe ist es die Datenkonsistenz sicherzustellen. Dafür entwickle ich " +
            "Verfahren um die Dateneingabe, -korrektur und -analyse zu automatisieren. ");
    JobItemTranslation apgEnglish = new JobItemTranslation(Locale.ENGLISH.getLanguage(), "APG", "System Administrator",
        "At APG I am actively working to maintain and manage a highly distributed, real time system " +
            "that is used to supervise and operate Austrias transmission power grid. I am tasked with keeping " +
            "data consistency and develop automated approaches to enter, analyze and correct data. Other tasks " +
            "include coordination of external contractors using the system and managing the exchange of information " +
            "with local energy providers. ");
    apgGerman.setJobItem(jobItem);
    apgEnglish.setJobItem(jobItem);
    List<JobItemTranslation> translations = new ArrayList<>();
    translations.add(apgEnglish);
    translations.add(apgGerman);
    return translations;
  }

  private static List<JobItemTranslation> getMedbitsTranslations(JobItem jobItem) {
    JobItemTranslation medbitsGerman = new JobItemTranslation(Locale.GERMAN.getLanguage(), "medbits", "Software Entwickler",
        "Im Kontext eines Projekts habe ich eine Softwaremodul entwickelt, das die direkte Abrechnung " +
            "mit den österreichischen Versicherungen, über ein von den Versicherungen definiertes Datenformat, " +
            "ermöglicht. Bei der Software handelt es sich um eine Java Applikation (Spring Boot). Eine Zertifizierung " +
            "soll in Kürze erfolgen.");
    JobItemTranslation medbitsEnglish = new JobItemTranslation(Locale.ENGLISH.getLanguage(), "medbits", "Software Engineer",
        "In the context of a project, I developed a Software Solution that allows medical professionals " +
            "to directly charge provided services with insurance companies using a predefined data exchange format. " +
            "The project was realized using Java (SpringBoot) and is awaiting certification. ");
    medbitsGerman.setJobItem(jobItem);
    medbitsEnglish.setJobItem(jobItem);
    List<JobItemTranslation> translations = new ArrayList<>();
    translations.add(medbitsGerman);
    translations.add(medbitsEnglish);
    return translations;
  }

  private static List<JobItemTranslation> getFitinnTranslations(JobItem jobItem) {
    JobItemTranslation fitinnGerman = new JobItemTranslation(Locale.GERMAN.getLanguage(), "FitInn", "Rezeptionist",
        "Verkaufsgespräche und Kundenbetreuung");
    JobItemTranslation fitinnEnglish = new JobItemTranslation(Locale.ENGLISH.getLanguage(), "FitInn", "Receptionist",
        "Sale of memberships and customer service");
    fitinnGerman.setJobItem(jobItem);
    fitinnEnglish.setJobItem(jobItem);
    List<JobItemTranslation> translations = new ArrayList<>();
    translations.add(fitinnGerman);
    translations.add(fitinnEnglish);
    return translations;
  }
}
