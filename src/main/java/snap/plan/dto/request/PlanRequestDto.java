package snap.plan.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import snap.common.enums.SpecialKeyword;
import snap.plan.entity.Plan;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 예약신청
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlanRequestDto {
    private Long photographerId;
    private LocalDateTime planDate;
    private SpecialKeyword category;
    private Long people;
    private String wishPlace;
    private String request;
    private String time;

    public Plan toEntity() {
        return Plan.builder()
                .planDate(planDate)
                .time(time)
                .category(category)
                .people(people)
                .wishPlace(wishPlace)
                .request(request)
                .build();
    }


}
