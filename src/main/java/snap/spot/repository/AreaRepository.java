package snap.spot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.spot.entity.Area;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {

    List<Area> findAllByMetropolitanContaining(String metropolitan);

    List<Area> findAllByCityContaining(String city);
}
