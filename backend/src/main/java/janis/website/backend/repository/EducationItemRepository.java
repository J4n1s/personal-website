package janis.website.backend.repository;

import janis.website.backend.entity.EducationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository interface for managing {@link EducationItem} entities.
 * Extends Spring Data JPA's JpaRepository to provide CRUD operations.
 */
@Repository
public interface EducationItemRepository extends JpaRepository<EducationItem, Long> {

  /**
   * Finds all EducationItem entities that have translations in a specific language, ordering the
   * results first by ending year (descending) and then by starting year (descending). If the
   * ending year is null, those items will be listed first.
   *
   * @param language the language of the translations to filter EducationItem entities by
   * @return a list of EducationItem entities filtered by the specified language and ordered by
   *     ending and starting years
   */
  @Query("SELECT DISTINCT ei FROM EducationItem ei "
      + "JOIN FETCH ei.translations t "
      + "WHERE t.language = :language "
      + "ORDER BY ei.endingYear DESC NULLS FIRST, ei.startingYear DESC")
  List<EducationItem> findAllByLanguageOrderByStartingYear(@Param("language") String language);
}
