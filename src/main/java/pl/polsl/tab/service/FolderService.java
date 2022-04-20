package pl.polsl.tab.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.polsl.tab.domain.Folder;

/**
 * Service Interface for managing {@link Folder}.
 */
public interface FolderService {
    /**
     * Save a folder.
     *
     * @param folder the entity to save.
     * @return the persisted entity.
     */
    Folder save(Folder folder);

    /**
     * Partially updates a folder.
     *
     * @param folder the entity to update partially.
     * @return the persisted entity.
     */
    Optional<Folder> partialUpdate(Folder folder);

    /**
     * Get all the folders.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Folder> findAll(Pageable pageable);

    /**
     * Get all the folders with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Folder> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Get the "id" folder.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Folder> findOne(Long id);

    /**
     * Delete the "id" folder.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
