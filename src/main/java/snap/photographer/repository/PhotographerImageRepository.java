package snap.photographer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.photographer.entity.Photographer;
import snap.photographer.entity.PhotographerImage;

import java.util.List;

public interface PhotographerImageRepository extends JpaRepository<PhotographerImage, Long> {

    List<PhotographerImage> findAllByPhotographer(Photographer photographer);
}
