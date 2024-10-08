package janis.website.backend.controller;

import com.fasterxml.jackson.databind.JsonNode;
import janis.website.backend.exception.NotFoundException;
import janis.website.backend.service.LanguageService;
import janis.website.backend.service.TextService;
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
@RequestMapping(value = "api/v1/text")
public class TextController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final TextService textService;
    private final LanguageService languageService;

    @Autowired
    public TextController(TextService textService, LanguageService languageService) {
        this.textService = textService;
        this.languageService = languageService;
    }

    @CrossOrigin
    @GetMapping(value = "/contact-form")
    ResponseEntity<JsonNode> getContactFormText() {
        LOGGER.info("GET api/v1/text/contact-form");
        try {
            return ResponseEntity.ok(textService.getContactFormText(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("Error getting contact form text", e);
            return ResponseEntity.notFound().build();
        }
    }
}
