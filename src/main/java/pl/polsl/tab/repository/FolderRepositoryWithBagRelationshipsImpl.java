package pl.polsl.tab.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.hibernate.annotations.QueryHints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import pl.polsl.tab.domain.Folder;

/**
 * Utility repository to load bag relationships based on https://vladmihalcea.com/hibernate-multiplebagfetchexception/
 */
public class FolderRepositoryWithBagRelationshipsImpl implements FolderRepositoryWithBagRelationships {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<Folder> fetchBagRelationships(Optional<Folder> folder) {
        return folder.map(this::fetchImages);
    }

    @Override
    public Page<Folder> fetchBagRelationships(Page<Folder> folders) {
        return new PageImpl<>(fetchBagRelationships(folders.getContent()), folders.getPageable(), folders.getTotalElements());
    }

    @Override
    public List<Folder> fetchBagRelationships(List<Folder> folders) {
        return Optional.of(folders).map(this::fetchImages).get();
    }

    Folder fetchImages(Folder result) {
        return entityManager
            .createQuery("select folder from Folder folder left join fetch folder.images where folder is :folder", Folder.class)
            .setParameter("folder", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Folder> fetchImages(List<Folder> folders) {
        return entityManager
            .createQuery("select distinct folder from Folder folder left join fetch folder.images where folder in :folders", Folder.class)
            .setParameter("folders", folders)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
    }
}
