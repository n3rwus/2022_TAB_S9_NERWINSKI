package pl.polsl.tab.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.hibernate.annotations.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import pl.polsl.tab.domain.Category;

/**
 * Utility repository to load bag relationships based on https://vladmihalcea.com/hibernate-multiplebagfetchexception/
 */
public class CategoryRepositoryWithBagRelationshipsImpl implements CategoryRepositoryWithBagRelationships {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<Category> fetchBagRelationships(Optional<Category> category) {
        return category.map(this::fetchImages);
    }

    @Override
    public Page<Category> fetchBagRelationships(Page<Category> categories) {
        return new PageImpl<>(fetchBagRelationships(categories.getContent()), categories.getPageable(), categories.getTotalElements());
    }

    @Override
    public List<Category> fetchBagRelationships(List<Category> categories) {
        return Optional.of(categories).map(this::fetchImages).get();
    }

    Category fetchImages(Category result) {
        return entityManager
            .createQuery(
                "select category from Category category left join fetch category.images where category is :category",
                Category.class
            )
            .setParameter("category", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Category> fetchImages(List<Category> categories) {
        return entityManager
            .createQuery(
                "select distinct category from Category category left join fetch category.images where category in :categories",
                Category.class
            )
            .setParameter("categories", categories)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
    }
}
