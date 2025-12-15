package snap.plan.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import snap.member.dto.MemberResponseDto;
import snap.message.dto.MessageResponseDto;
import snap.member.entity.Member;
import snap.message.entity.Message;
import snap.common.enums.SpecialKeyword;
import snap.plan.entity.Plan;
import snap.common.enums.Status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlanFullResponseDto {
    private UUID planId;
    private MemberResponseDto customer;
    private MemberResponseDto photographer;
    private LocalDateTime planDate;
    private String time;
    private SpecialKeyword category;
    private Long people;
    private String wishPlace;
    private String request;
    private Long price;
    private String placeName;
    private String placeAddress;
    private String x;
    private String y;
    private Status status;
    private List<MessageResponseDto> messages;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder
    public PlanFullResponseDto(Plan plan, Member member, List<Message> messageList) {
        this.planId = plan.getPlanId();
        this.customer = new MemberResponseDto(plan.getCustomer());
        this.photographer = new MemberResponseDto(plan.getPhotographer().getMember());
        this.planDate = plan.getPlanDate();
        this.category = plan.getCategory();
        this.people = plan.getPeople();
        this.wishPlace = plan.getWishPlace();
        this.time = plan.getTime();
        this.request = plan.getRequest();
        this.price = plan.getPrice();
        this.placeName = plan.getPlaceName();
        this.placeAddress = plan.getPlaceAddress();
        this.x = plan.getX();
        this.y = plan.getY();
        this.status = plan.getStatus();
        this.messages = messageList.stream()
                .map(message -> new MessageResponseDto(message, member))
                .collect(Collectors.toList());
        this.createdAt = plan.getCreatedAt();
        this.modifiedAt = plan.getModifiedAt();
    }
}
