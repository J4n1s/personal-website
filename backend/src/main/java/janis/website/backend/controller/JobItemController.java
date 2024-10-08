package janis.website.backend.controller;

import janis.website.backend.controller.dto.JobItemDto;
import janis.website.backend.controller.mapper.JobItemMapper;
import janis.website.backend.service.JobItemService;
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
@RequestMapping(value = "api/v1/jobs")
public class JobItemController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final JobItemService jobItemService;
    private final JobItemMapper jobItemMapper;

    @Autowired
    public JobItemController(JobItemService jobItemService, JobItemMapper jobItemMapper) {
        this.jobItemService = jobItemService;
        this.jobItemMapper = jobItemMapper;
    }

    @GetMapping
    ResponseEntity<List<JobItemDto>> all() {
        LOGGER.info("GET api/v1/jobs");
        return ResponseEntity.ok(
                jobItemMapper.entityToDto(jobItemService.getAllByLanguage(LocaleContextHolder.getLocale().getLanguage()))
        );
    }
}
