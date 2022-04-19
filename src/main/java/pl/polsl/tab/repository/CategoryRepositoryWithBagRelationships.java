package pl.polsl.tab.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import pl.polsl.tab.domain.Category;

public interface CategoryRepositoryWithBagRelationships {
    Optional<Category> fetchBagRelationships(Optional<Category> category);

    List<Category> fetchBagRelationships(List<Category> categories);

    Page<Category> fetchBagRelationships(Page<Category> categories);
}
