package pl.polsl.tab.repository;

import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import pl.polsl.tab.domain.Image;

/**
 * Spring Data SQL repository for the Image entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query("select image from Image image where image.user.login = ?#{principal.username}")
    List<Image> findByUserIsCurrentUser();
}
