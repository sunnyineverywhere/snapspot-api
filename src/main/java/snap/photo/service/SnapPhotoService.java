package snap.api.photo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import snap.photo.dto.SnapPhotoRequestDto;
import snap.photo.dto.SnapPhotoResponseDto;
import snap.member.entity.Member;
import snap.photo.service.SnapPhotoDomainService;
import snap.photographer.entity.Photographer;
import snap.photographer.service.PhotographerDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SnapPhotoService {

    private final SnapPhotoDomainService snapPhotoDomainService;
    private final PhotographerDomainService photographerDomainService;

    public SnapPhotoResponseDto createPhoto(Member member, SnapPhotoRequestDto requestDto) {
        Photographer photographer = photographerDomainService.findById(requestDto.getPhotographerId());
        return new SnapPhotoResponseDto(snapPhotoDomainService.createPhoto(member, requestDto.getImageUrl(), requestDto.getPhotoDate(),
                requestDto.getLocation(), photographer, requestDto.getTag1(), requestDto.getTag2(), requestDto.getTag3()));
    }

    public List<SnapPhotoResponseDto> findPhotoListByMember(Member member) {
        return snapPhotoDomainService.findPhotoListByMember(member).stream().map(SnapPhotoResponseDto::new).toList();
    }
}
