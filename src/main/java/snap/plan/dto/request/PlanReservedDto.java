package snap.plan.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import snap.message.entity.Message;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlanReservedDto {
    private UUID planId;
    private String contents;

    public Message toEntity() {
        return Message.builder()
                .contents(contents)
                .build();
    }
}
