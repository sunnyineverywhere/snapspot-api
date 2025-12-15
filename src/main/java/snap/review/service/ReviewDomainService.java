package snap.review.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import snap.member.entity.Member;
import snap.photographer.entity.Photographer;
import snap.plan.entity.Plan;
import snap.review.entity.Review;
import snap.review.repository.ReviewRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewDomainService {
    private final ReviewRepository reviewRepository;

    public void createReview(Plan plan, String image, Integer score, String title, String comment) {
        reviewRepository.save(
                Review.builder().image(image).title(title).comment(comment).score(score).plan(plan)
                .build());
    }

    public List<Review> findReviewListByPhotographer(Photographer photographer) {
        return reviewRepository.findAllByPlan_Photographer(photographer);
    }

    public List<Review> findReviewListByMember(Member member) {
        return reviewRepository.findAllByPlan_CustomerOrderByScoreDesc(member);
    }
}
