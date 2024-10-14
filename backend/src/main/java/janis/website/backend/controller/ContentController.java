package janis.website.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
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
}