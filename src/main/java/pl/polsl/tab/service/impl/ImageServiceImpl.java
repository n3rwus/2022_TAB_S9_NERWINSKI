package pl.polsl.tab.service.impl;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.tab.domain.Image;
import pl.polsl.tab.repository.ImageRepository;
import pl.polsl.tab.service.ImageService;

/**
 * Service Implementation for managing {@link Image}.
 */
@Service
@Transactional
public class ImageServiceImpl implements ImageService {

    private final Logger log = LoggerFactory.getLogger(ImageServiceImpl.class);

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Image save(Image image) {
        log.debug("Request to save Image : {}", image);
        return imageRepository.save(image);
    }

    @Override
    public Optional<Image> partialUpdate(Image image) {
        log.debug("Request to partially update Image : {}", image);

        return imageRepository
            .findById(image.getId())
            .map(existingImage -> {
                if (image.getName() != null) {
                    existingImage.setName(image.getName());
                }
                if (image.getImage() != null) {
                    existingImage.setImage(image.getImage());
                }
                if (image.getImageContentType() != null) {
                    existingImage.setImageContentType(image.getImageContentType());
                }
                if (image.getDescription() != null) {
                    existingImage.setDescription(image.getDescription());
                }
                if (image.getImageSize() != null) {
                    existingImage.setImageSize(image.getImageSize());
                }
                if (image.getFormat() != null) {
                    existingImage.setFormat(image.getFormat());
                }
                if (image.getDateOfCreate() != null) {
                    existingImage.setDateOfCreate(image.getDateOfCreate());
                }

                return existingImage;
            })
            .map(imageRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Image> findAll(Pageable pageable) {
        log.debug("Request to get all Images");
        return imageRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Image> findOne(Long id) {
        log.debug("Request to get Image : {}", id);
        return imageRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Image : {}", id);
        imageRepository.deleteById(id);
    }
}
