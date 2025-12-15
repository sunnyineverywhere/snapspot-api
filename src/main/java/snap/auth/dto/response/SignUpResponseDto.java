package snap.auth.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import snap.member.entity.Member;
import snap.common.enums.Role;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpResponseDto {
    private String nickname;
    private String email;
    private Role role;

    @Builder
    public SignUpResponseDto(Member entity) {
        this.nickname = entity.getNickname();
        this.email = entity.getEmail();
        this.role = entity.getRole();
    }
}
