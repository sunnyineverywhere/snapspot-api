package snap.photo.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import snap.member.entity.Member;
import snap.photo.entity.SnapPhoto;

import java.util.List;

public interface SnapPhotoRepository extends JpaRepository<SnapPhoto, Long> {

    List<SnapPhoto> findAllByMember(Member member);
}
