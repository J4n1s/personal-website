package janis.website.backend.repository;

import janis.website.backend.entity.JobItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing {@link JobItem} entities.
 * Extends Spring Data JPA's JpaRepository to provide CRUD operations.
 */
@Repository
public interface JobItemRepository extends JpaRepository<JobItem, Long> {

  /**
   * Retrieves a list of distinct {@link JobItem} entities filtered by the specified language
   * and ordered by the ending year in descending order (with nulls first)
   * and then by the starting year in descending order.
   *
   * @param language the language to filter job item translations by
   * @return a list of job items that match the specified language, ordered by ending year and
   *     starting year
   */
  @Query("SELECT distinct ji from JobItem ji "
      + "JOIN FETCH ji.translations t "
      + "WHERE t.language = :language "
      + "ORDER BY ji.endingYear DESC NULLS FIRST, ji.startingYear DESC")
  List<JobItem> findAllByLanguageOrderByStartingYear(@Param("language") String language);
}
