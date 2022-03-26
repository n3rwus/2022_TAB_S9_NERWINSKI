package pl.polsl.tab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.tab.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
