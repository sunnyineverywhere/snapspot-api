package snap.message.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snap.message.entity.Message;
import snap.message.entity.Sender;
import snap.message.repository.MessageRepository;
import snap.plan.entity.Plan;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageDomainService {

    private final MessageRepository messageRepository;

    public Message createMessage(Plan plan, String contents, Sender sender) {
        return messageRepository.save(Message.builder()
                .plan(plan)
                .contents(contents)
                .sender(sender)
                .build());
    }

    public List<Message> findByPlanId(UUID planId) {
        return messageRepository.findAllByPlan_PlanId(planId);
    }

    public List<Message> findByPlanEntity(Plan plan) {
        return messageRepository.findByPlan(plan);
    }
}
