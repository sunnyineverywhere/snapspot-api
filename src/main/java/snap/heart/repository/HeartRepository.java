package snap.heart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.heart.entity.Heart;
import snap.member.entity.Member;
import snap.photographer.entity.Photographer;

import java.util.List;
import java.util.Optional;

public interface HeartRepository extends JpaRepository<Heart, Long> {

    List<Heart> findByMember(Member member);

    Optional<Heart> findByMemberAndPhotographer(Member member, Photographer photographer);

    Boolean existsByMemberAndPhotographer(Member member, Photographer photographer);
}
