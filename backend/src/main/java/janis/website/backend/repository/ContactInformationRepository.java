package janis.website.backend.repository;

import janis.website.backend.entity.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on ContactInformation entities.
 * Extends JpaRepository to provide methods for common data access tasks.
 */
@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation, Long> {
}