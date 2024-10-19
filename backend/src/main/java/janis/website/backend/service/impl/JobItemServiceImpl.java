package janis.website.backend.service.impl;

import janis.website.backend.entity.JobItem;
import janis.website.backend.repository.JobItemRepository;
import janis.website.backend.service.JobItemService;
import janis.website.backend.service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
public class JobItemServiceImpl implements JobItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final JobItemRepository jobItemRepository;

    @Autowired
    public JobItemServiceImpl(JobItemRepository jobItemRepository) {
        this.jobItemRepository = jobItemRepository;
    }

    @Override
    public List<JobItem> getAllByLanguage(String language) {
        LOGGER.info("Getting all job items by language {}", language);

        List<JobItem> jobItems = jobItemRepository.findAllByLanguageOrderByStartingYear(language);
        if (jobItems == null || jobItems.isEmpty()) {
            jobItems = jobItemRepository.findAllByLanguageOrderByStartingYear(LanguageService.DEFAULT_LANGUAGE);
        }
        return jobItems;
    }
}
