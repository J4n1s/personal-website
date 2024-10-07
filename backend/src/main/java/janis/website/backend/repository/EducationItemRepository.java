package janis.website.backend.repository;

import janis.website.backend.entity.EducationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EducationItemRepository extends JpaRepository<EducationItem, Long> {

    @Query("SELECT DISTINCT ei FROM EducationItem ei " +
            "JOIN FETCH ei.translations t " +
            "WHERE t.language = :language")
    List<EducationItem> findAllByLanguage(@Param("language") String language);
}
