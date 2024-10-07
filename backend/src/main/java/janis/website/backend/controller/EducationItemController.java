package janis.website.backend.controller;

import janis.website.backend.controller.dto.EducationItemDto;
import janis.website.backend.controller.mapper.EducationItemMapper;
import janis.website.backend.service.EducationItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/education")
public class EducationItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final EducationItemService educationItemService;
    private final EducationItemMapper educationItemMapper;

    @Autowired
    public EducationItemController(EducationItemService educationItemService, EducationItemMapper educationItemMapper) {
        this.educationItemService = educationItemService;
        this.educationItemMapper = educationItemMapper;
    }

    @GetMapping
    ResponseEntity<List<EducationItemDto>> all() {
        LOGGER.info("GET api/v1/education");
        return ResponseEntity.ok(
                educationItemMapper.entityToDto(educationItemService.getAllByLanguage(LocaleContextHolder.getLocale().getLanguage()))
        );
    }
}
