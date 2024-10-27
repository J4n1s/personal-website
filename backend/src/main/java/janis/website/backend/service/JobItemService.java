package janis.website.backend.service;

import janis.website.backend.entity.JobItem;

import java.util.List;

/**
 * Service interface for managing {@link JobItem} entities.
 * Provides methods to retrieve job items filtered by language.
 */
public interface JobItemService {

  /**
   * Retrieves a list of all JobItem entities that match the specified language.
   *
   * @param language the language for which to retrieve job items
   * @return a list of JobItem entities filtered by the specified language
   */
  List<JobItem> getAllByLanguage(String language);
}
