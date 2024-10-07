package janis.website.backend.service.impl;

import janis.website.backend.entity.EducationItem;
import janis.website.backend.repository.EducationItemRepository;
import janis.website.backend.service.EducationItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

@Service
public class EducationItemServiceImpl implements EducationItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    private EducationItemRepository educationItemRepository;

    @Override
    public List<EducationItem> getAllByLanguage(String language) {
        LOGGER.info("Getting all education items for {}", language);

        List<EducationItem> educationItems = educationItemRepository.findAllByLanguageOrderByStartingYear(language);
        if (educationItems == null || educationItems.isEmpty()) {
            educationItems = educationItemRepository.findAllByLanguageOrderByStartingYear("de");
        }
        return educationItems;
    }
}
