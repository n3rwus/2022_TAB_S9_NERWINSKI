package pl.polsl.tab.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.tab.domain.Folder;
import pl.polsl.tab.repository.FolderRepository;
import pl.polsl.tab.service.FolderService;

/**
 * Service Implementation for managing {@link Folder}.
 */
@Service
@Transactional
public class FolderServiceImpl implements FolderService {

    private final Logger log = LoggerFactory.getLogger(FolderServiceImpl.class);

    private final FolderRepository folderRepository;

    public FolderServiceImpl(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    @Override
    public Folder save(Folder folder) {
        log.debug("Request to save Folder : {}", folder);
        return folderRepository.save(folder);
    }

    @Override
    public Optional<Folder> partialUpdate(Folder folder) {
        log.debug("Request to partially update Folder : {}", folder);

        return folderRepository
            .findById(folder.getId())
            .map(existingFolder -> {
                if (folder.getName() != null) {
                    existingFolder.setName(folder.getName());
                }
                if (folder.getDescription() != null) {
                    existingFolder.setDescription(folder.getDescription());
                }

                return existingFolder;
            })
            .map(folderRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Folder> findAll(Pageable pageable) {
        log.debug("Request to get all Folders");
        return folderRepository.findAll(pageable);
    }

    public Page<Folder> findAllWithEagerRelationships(Pageable pageable) {
        return folderRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Folder> findOne(Long id) {
        log.debug("Request to get Folder : {}", id);
        return folderRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Folder : {}", id);
        folderRepository.deleteById(id);
    }
}
