package snap.photographer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import snap.member.service.MemberService;
import snap.member.dto.MemberModifyRequestDto;
import snap.member.dto.MemberResponseDto;
import snap.photographer.dto.request.PhotographerCustomDto;
import snap.photographer.dto.response.PhotographerNameResponseDto;
import snap.photographer.dto.response.PhotographerResponseDto;
import snap.photographer.dto.response.PhotographerSearchResponseDto;
import snap.photographer.dto.response.PhotographerWithHeartDto;
import snap.photographer.dto.response.PhotographerSimpleDto;
import snap.photographer.service.PhotographerService;
import snap.review.service.ReviewService;
import snap.member.entity.Member;
import snap.photographer.entity.Photographer;
import snap.common.dto.PhotographerFilterReq;
import snap.infrastructure.security.resolver.AuthPhotographer;
import snap.infrastructure.security.service.JwtSecurityService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photographers")
public class PhotographerController {

    private final PhotographerService photographerService;
    private final ReviewService reviewService;
    private final MemberService memberService;
    private final JwtSecurityService jwtSecurityService;

    @GetMapping("/me")
    public ResponseEntity<PhotographerResponseDto> photographerInfoFind(@AuthPhotographer Photographer photographer) {
        return new ResponseEntity<>(new PhotographerResponseDto(photographer, reviewService.findReviewInfoByPhotographer(photographer)), HttpStatus.OK);
    }

    @PutMapping("/me")
    public ResponseEntity<PhotographerResponseDto> photographerInfoUpdate(@AuthPhotographer Photographer photographer,
                                                                          @RequestBody PhotographerCustomDto dto) {
        return new ResponseEntity<>(photographerService.updatePhotographerInfo(photographer, dto), HttpStatus.OK);
    }

    @GetMapping("/{photographerId}")
    public ResponseEntity<PhotographerWithHeartDto> photographerFindById(@PathVariable Long photographerId, HttpServletRequest request) {
        Member member = jwtSecurityService.getMemberByRequest(request).getMember();
        return new ResponseEntity<>(photographerService.findPhotographer(photographerId, member), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<PhotographerSearchResponseDto> search(@RequestParam String keyword){
        return new ResponseEntity<>(photographerService.findBySearch(keyword), HttpStatus.OK);
    }

    @GetMapping("/tag")
    public ResponseEntity<List<PhotographerSimpleDto>> photographerFindByTag(@RequestParam String tag){
        return new ResponseEntity<>(photographerService.findByTag(tag), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PhotographerSimpleDto>> photographerList(PhotographerFilterReq filterReq){
        return new ResponseEntity<>(photographerService.findByFilter(filterReq), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<PhotographerNameResponseDto>> photographerNameList(){
        return new ResponseEntity<>(photographerService.findAllNames(), HttpStatus.OK);
    }

    @PutMapping("/setting")
    public ResponseEntity<MemberResponseDto> photographerUpdate(@AuthPhotographer Photographer photographer, @RequestBody MemberModifyRequestDto requestDto){
        return new ResponseEntity<>(memberService.updateMember(photographer.getMember(), requestDto), HttpStatus.OK);
    }
}
