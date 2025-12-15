package snap.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.member.entity.Member;
import snap.photographer.entity.Photographer;
import snap.review.entity.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByPlan_Photographer(Photographer photographer);
    List<Review> findAllByPlan_CustomerOrderByScoreDesc(Member customer);
}
