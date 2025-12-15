package snap.photographer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.photographer.entity.Photographer;
import snap.photographer.entity.PhotographerArea;
import snap.spot.entity.Area;

import java.util.List;

import java.util.Optional;

public interface PhotographerAreaRepository extends JpaRepository<PhotographerArea, Long> {

    List<PhotographerArea> findAllByArea(Area area);

    List<PhotographerArea> findAllByPhotographer(Photographer photographer);
}
