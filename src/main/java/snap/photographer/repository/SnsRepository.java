package snap.photographer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.photographer.entity.Photographer;
import snap.photographer.entity.Sns;

import java.util.Optional;

public interface SnsRepository extends JpaRepository<Sns, Long> {

    Optional<Sns> findByPhotographer(Photographer photographer);
}
