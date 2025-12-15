package snap.photographer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.photographer.entity.Photographer;
import snap.photographer.entity.PhotographerSchedule;

import java.util.List;

public interface PhotographerScheduleRepository extends JpaRepository<PhotographerSchedule, Long> {

    List<PhotographerSchedule> findAllByPhotographer(Photographer photographer);
}
