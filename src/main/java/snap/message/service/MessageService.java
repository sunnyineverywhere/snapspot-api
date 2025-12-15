package snap.message.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import snap.message.dto.MessageRequestDto;
import snap.message.dto.MessageResponseDto;
import snap.member.entity.Member;
import snap.message.entity.Message;
import snap.message.entity.Sender;
import snap.message.service.MessageDomainService;
import snap.plan.entity.Plan;
import snap.plan.service.PlanDomainService;
import snap.common.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final PlanDomainService planDomainService;
    private final MessageDomainService messageDomainService;

    public Message createMessage(Member member, MessageRequestDto request) {
        Sender sender = Sender.MEMBER;
        if (member.getRole().equals(Role.ROLE_PHOTOGRAPHER)) {
            sender = Sender.PHOTOGRAPHER;
        }
        Plan plan = planDomainService.findByPlanId(request.getPlanId());

        if (!plan.getCustomer().getMemberId().equals(member.getMemberId()))
        {
            if (!plan.getPhotographer().getMember().getMemberId().equals(member.getMemberId())) {
                throw new IllegalArgumentException("사진 촬영 일정에 대해 권한이 있는 일반 계정 혹은 사진작가 계정이 아닙니다.");
            }
        }

        return messageDomainService.createMessage(
                plan,
                request.getContents(),
                sender
        );
    }

    public List<MessageResponseDto> getMessages(Member member, UUID planId) {
        List<Message> messageList = messageDomainService.findByPlanId(planId);
        return messageList.stream()
                .map(message -> new MessageResponseDto(message, member))
                .collect(Collectors.toList());
    }
}
