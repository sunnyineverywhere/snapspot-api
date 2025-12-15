package snap.api.member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import snap.member.dto.LoginRequestDto;
import snap.member.dto.MemberModifyRequestDto;
import snap.member.dto.MemberResponseDto;
import snap.member.dto.SignupRequestDto;
import snap.member.entity.Member;
import snap.infrastructure.security.resolver.AuthMember;
import snap.member.service.MemberService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> memberInfoFind(@AuthMember Member member) {
        return new ResponseEntity<>(new MemberResponseDto(member), HttpStatus.OK);
    }

    @PutMapping("/setting")
    public ResponseEntity<MemberResponseDto> memberUpdate(@AuthMember Member member, @RequestBody MemberModifyRequestDto requestDto){
        return new ResponseEntity<>(memberService.updateMember(member, requestDto), HttpStatus.OK);
    }
}
