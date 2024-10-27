package janis.website.backend.service.impl;

import janis.website.backend.entity.EducationItem;
import janis.website.backend.repository.EducationItemRepository;
import janis.website.backend.service.EducationItemService;
import janis.website.backend.service.LanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * Service implementation for managing education items. This class provides methods
 * to retrieve education items based on specific criteria, such as language.
 */
@Service
public class EducationItemServiceImpl implements EducationItemService {

  private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  private final EducationItemRepository educationItemRepository;

  /**
   * Constructs a new instance of {@link EducationItemServiceImpl} with the specified
   * {@link EducationItemRepository}.
   *
   * @param educationItemRepository the repository used to manage {@link EducationItem} entities
   */
  @Autowired
  public EducationItemServiceImpl(EducationItemRepository educationItemRepository) {
    this.educationItemRepository = educationItemRepository;
  }

  @Override
  public List<EducationItem> getAllByLanguage(String language) {
    LOGGER.info("Getting all education items by language {}", language);

    List<EducationItem> educationItems = educationItemRepository
        .findAllByLanguageOrderByStartingYear(language);
    if (educationItems == null || educationItems.isEmpty()) {
      educationItems = educationItemRepository
          .findAllByLanguageOrderByStartingYear(LanguageService.DEFAULT_LANGUAGE);
    }
    return educationItems;
  }
}
