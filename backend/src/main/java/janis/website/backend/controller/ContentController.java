package janis.website.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import janis.website.backend.controller.dto.SkillDto;
import janis.website.backend.exception.NotFoundException;
import janis.website.backend.service.LanguageService;
import janis.website.backend.service.ContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/content")
public class ContentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ContentService contentService;
    private final LanguageService languageService;

    @Autowired
    public ContentController(ContentService contentService, LanguageService languageService) {
        this.contentService = contentService;
        this.languageService = languageService;
    }

    @CrossOrigin
    @GetMapping(value = "/contact-form")
    ResponseEntity<JsonNode> getContactFormContent() {
        LOGGER.info("GET api/v1/content/contact-form");
        try {
            return ResponseEntity.ok(contentService.getContactFormContent(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("Error getting contact form content", e);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/resume")
    ResponseEntity<JsonNode> getResumeContent() {
        LOGGER.info("GET api/v1/content/resume");
        try {
            return ResponseEntity.ok(contentService.getResumeContent(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("Error getting resume content", e);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/interests")
    ResponseEntity<JsonNode> getInterestsContent() {
        LOGGER.info("GET api/v1/content/interests");
        try {
            return ResponseEntity.ok(contentService.getInterestsContent(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("Error getting interests content", e);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/skills")
    ResponseEntity<List<SkillDto>> getSkills() {
        LOGGER.info("GET api/v1/resume/skills");
        try {
            return ResponseEntity.ok(contentService.getSkills(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("getSkills failed", e);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/footer")
    ResponseEntity<JsonNode> getFooterContent() {
        LOGGER.info("GET api/v1/content/footer");
        try {
            return ResponseEntity.ok(contentService.getFooterContent(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("Error getting footer content", e);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/header")
    ResponseEntity<JsonNode> getHeaderContent() {
        LOGGER.info("GET api/v1/content/header");
        try {
            return ResponseEntity.ok(contentService.getHeaderContent(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("Error getting header content", e);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/404")
    ResponseEntity<JsonNode> get404Content() {
        LOGGER.info("GET api/v1/content/404");
        try {
            return ResponseEntity.ok(contentService.get404Content(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("Error getting 404 content", e);
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @GetMapping(value = "/home")
    ResponseEntity<JsonNode> getHomeContent() {
        LOGGER.info("GET api/v1/content/home");
        try {
            return ResponseEntity.ok(contentService.getHomeContent(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("Error getting home content", e);
            return ResponseEntity.notFound().build();
        }
    }
}
