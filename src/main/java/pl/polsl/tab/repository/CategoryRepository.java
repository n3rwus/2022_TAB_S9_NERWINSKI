package pl.polsl.tab.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.polsl.tab.domain.Category;

/**
 * Spring Data SQL repository for the Category entity.
 */
@Repository
public interface CategoryRepository
    extends CategoryRepositoryWithBagRelationships, JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {
    default Optional<Category> findOneWithEagerRelationships(Long id) {
        return this.fetchBagRelationships(this.findById(id));
    }

    default List<Category> findAllWithEagerRelationships() {
        return this.fetchBagRelationships(this.findAll());
    }

    default Page<Category> findAllWithEagerRelationships(Pageable pageable) {
        return this.fetchBagRelationships(this.findAll(pageable));
    }
}
