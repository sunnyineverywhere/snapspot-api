package snap.plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snap.member.entity.Member;
import snap.photographer.entity.Photographer;
import snap.plan.entity.Plan;
import snap.common.enums.Status;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlanJPARepository extends JpaRepository<Plan, UUID> {

    List<Plan> findAllByCustomerOrderByCreatedAtDesc(Member member);
    List<Plan> findAllByPhotographerOrderByCreatedAtDesc(Photographer photographer);

    List<Plan> findAllByPhotographerAndStatus(Photographer photographer, Status status1);

    List<Plan> findAllByPhotographerAndStatusOrStatusOrderByCreatedAtDesc(Photographer photographer, Status status1, Status status2);
    List<Plan> findAllByPhotographerAndStatusOrStatusOrStatusOrderByCreatedAtDesc(Photographer photographer, Status status1, Status status2, Status status3);

    Optional<Plan> findByPlanIdAndCustomer(UUID planId, Member member);

}
