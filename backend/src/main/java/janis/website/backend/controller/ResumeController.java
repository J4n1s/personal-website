package janis.website.backend.controller;

import janis.website.backend.controller.dto.SkillDto;
import janis.website.backend.exception.NotFoundException;
import janis.website.backend.service.LanguageService;
import janis.website.backend.service.ResumeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/resume")
public class ResumeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final ResumeService resumeService;
    private final LanguageService languageService;

    @Autowired
    public ResumeController(ResumeService resumeService, LanguageService languageService) {
        this.resumeService = resumeService;
        this.languageService = languageService;
    }

    @CrossOrigin
    @GetMapping(value = "/skills")
    ResponseEntity<List<SkillDto>> getSkills() {
        LOGGER.info("GET api/v1/resume/skills");
        try {
            return ResponseEntity.ok(resumeService.getSkills(languageService.getLanguage()));
        } catch (NotFoundException e) {
            LOGGER.error("getSkills failed", e);
            return ResponseEntity.notFound().build();
        }
    }
}
