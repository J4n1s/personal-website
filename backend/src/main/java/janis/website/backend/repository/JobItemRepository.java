package janis.website.backend.repository;

import janis.website.backend.entity.JobItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobItemRepository extends JpaRepository<JobItem, Long> {

    @Query("SELECT distinct ji from JobItem ji " +
            "JOIN FETCH ji.translations t " +
            "WHERE t.language = :language " +
            "ORDER BY ji.startingYear DESC")
    List<JobItem> findAllByLanguageOrderByStartingYear(@Param("language") String language);
}
