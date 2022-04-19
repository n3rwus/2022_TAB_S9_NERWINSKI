package pl.polsl.tab.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.tab.domain.Folder;

/**
 * Spring Data SQL repository for the Folder entity.
 */
@Repository
public interface FolderRepository extends FolderRepositoryWithBagRelationships, JpaRepository<Folder, Long> {
    @Query("select folder from Folder folder where folder.user.login = ?#{principal.username}")
    List<Folder> findByUserIsCurrentUser();

    default Optional<Folder> findOneWithEagerRelationships(Long id) {
        return this.fetchBagRelationships(this.findById(id));
    }

    default List<Folder> findAllWithEagerRelationships() {
        return this.fetchBagRelationships(this.findAll());
    }

    default Page<Folder> findAllWithEagerRelationships(Pageable pageable) {
        return this.fetchBagRelationships(this.findAll(pageable));
    }
}
