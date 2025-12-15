package snap.photographer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.photographer.entity.Photographer;
import snap.photographer.entity.Special;

import java.util.List;

public interface SpecialRepository extends JpaRepository<Special, Long> {

    List<Special> findAllByPhotographer(Photographer photographer);
}
