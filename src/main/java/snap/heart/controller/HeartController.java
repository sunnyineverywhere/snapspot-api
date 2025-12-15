package snap.api.heart;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import snap.heart.dto.HeartCancelResponseDto;
import snap.heart.dto.HeartRequestDto;
import snap.heart.dto.HeartSuccessResponseDto;
import snap.photographer.dto.response.PhotographerResponseDto;
import snap.photographer.dto.response.PhotographerSimpleDto;
import snap.member.entity.Member;
import snap.infrastructure.security.resolver.AuthMember;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hearts")
public class HeartController {

    private final HeartService heartService;

    @GetMapping
    public ResponseEntity<List<PhotographerSimpleDto>> heartList(@AuthMember Member member){
        return new ResponseEntity<>(heartService.heartListByMember(member), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HeartSuccessResponseDto> heartCreate(@AuthMember Member member, @RequestBody HeartRequestDto requestDto){
        return new ResponseEntity<>(heartService.heartCreate(member, requestDto.getPhotographerId()), HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<HeartCancelResponseDto> heartDelete(@AuthMember Member member, @RequestBody HeartRequestDto requestDto){
        return new ResponseEntity<>(heartService.heartDelete(member, requestDto.getPhotographerId()), HttpStatus.OK);
    }
}
