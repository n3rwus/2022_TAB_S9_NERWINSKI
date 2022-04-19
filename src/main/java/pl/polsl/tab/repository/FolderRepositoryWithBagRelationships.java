package pl.polsl.tab.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import pl.polsl.tab.domain.Folder;

public interface FolderRepositoryWithBagRelationships {
    Optional<Folder> fetchBagRelationships(Optional<Folder> folder);

    List<Folder> fetchBagRelationships(List<Folder> folders);

    Page<Folder> fetchBagRelationships(Page<Folder> folders);
}
