package snap.infrastructure.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import snap.member.entity.Member;

@Getter
@NoArgsConstructor
public class MemberRes {

	private Member member;

	public MemberRes(Member member){
		this.member = member;
	}
}
