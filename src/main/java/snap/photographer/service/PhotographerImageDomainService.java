package snap.photographer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snap.photographer.entity.Photographer;
import snap.photographer.entity.PhotographerImage;
import snap.photographer.repository.PhotographerImageRepository;
import snap.common.dto.ImageReq;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PhotographerImageDomainService {
    private final PhotographerImageRepository imageRepository;

    public void createPhotographer(Photographer photographer) {
        imageRepository.save(
                PhotographerImage.builder().photographer(photographer).build()
        );
    }

    public void updatePhotographerImage(Photographer photographer, ImageReq image) {
        photographer.getImages().update(image);
    }
}
