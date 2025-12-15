package snap.api.heart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import snap.heart.dto.HeartCancelResponseDto;
import snap.heart.dto.HeartSuccessResponseDto;
import snap.photographer.dto.response.PhotographerResponseDto;
import snap.photographer.dto.response.PhotographerSimpleDto;
import snap.review.service.ReviewService;
import snap.heart.service.HeartDomainService;
import snap.member.entity.Member;
import snap.photographer.entity.Photographer;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeartService {

    private final HeartDomainService heartDomainService;
    private final ReviewService reviewService;

    public List<PhotographerSimpleDto> heartListByMember(Member member){
        return heartDomainService.findHeartByMember(member).stream()
                .map(photographer -> new PhotographerSimpleDto(photographer,
                        reviewService.findReviewInfoByPhotographer(photographer))).toList();
    }

    public HeartSuccessResponseDto heartCreate(Member member, Long photographerId){
        return new HeartSuccessResponseDto(heartDomainService.createHeart(member, photographerId));
    }

    public HeartCancelResponseDto heartDelete(Member member, Long photographerId){
        Photographer photographer = heartDomainService.deleteHeart(member, photographerId);
        return new HeartCancelResponseDto(member, photographer);
    }
}
