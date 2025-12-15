package snap.photographer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.photographer.entity.Photographer;
import snap.photographer.entity.PhotographerTag;

import java.util.List;

public interface PhotographerTagRepository extends JpaRepository<PhotographerTag, Long> {

    List<PhotographerTag> findAllByTag1OrTag2OrTag3(String tag1, String tag2, String tag3);
}
