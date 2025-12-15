package snap.api.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import snap.photo.dto.SnapPhotoRequestDto;
import snap.photo.dto.SnapPhotoResponseDto;
import snap.member.entity.Member;
import snap.infrastructure.security.resolver.AuthMember;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photos")
public class SnapPhotoController {

    private final SnapPhotoService snapPhotoService;

    @PostMapping
    public ResponseEntity<SnapPhotoResponseDto> photoRegister(@AuthMember Member member, @RequestBody SnapPhotoRequestDto requestDto) {
        return new ResponseEntity<>(snapPhotoService.createPhoto(member, requestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SnapPhotoResponseDto>> photoList(@AuthMember Member member) {
        return new ResponseEntity<>(snapPhotoService.findPhotoListByMember(member), HttpStatus.OK);
    }
}
