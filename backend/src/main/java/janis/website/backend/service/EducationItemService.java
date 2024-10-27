package janis.website.backend.service;

import janis.website.backend.entity.EducationItem;

import java.util.List;

/**
 * Service interface for managing education items.
 * Provides methods to fetch education items based on specific criteria.
 */
public interface EducationItemService {

  /**
   * Retrieves a list of educational items based on the specified language.
   *
   * @param language the language in which to fetch educational items
   * @return a list of EducationItem objects matching the specified language
   */
  List<EducationItem> getAllByLanguage(String language);
}
