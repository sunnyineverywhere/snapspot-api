package snap.photographer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import snap.member.entity.Member;
import snap.photographer.entity.Photographer;

import java.util.Optional;

public interface PhotographerRepository extends JpaRepository<Photographer, Long>, PhotographerRepositoryCustom {
    Optional<Photographer> findByMember_Email(String email);

    Photographer findByMember(Member member);

    Page<Photographer> findAll(Pageable pageable);
    
    Optional<Photographer> findByPhotographerId(Long photographerId);

    Long countBy();
}
