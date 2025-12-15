package snap.spot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import snap.spot.dto.AreaImageResponseDto;
import snap.spot.dto.AreaResponseDto;
import snap.spot.service.AreaDomainService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaService {
    private final AreaDomainService areaDomainService;

    public AreaResponseDto findArea(Long areaId){
        return new AreaResponseDto(areaDomainService.findArea(areaId));
    }

    public List<AreaImageResponseDto> findAreaImages(Pageable pageable) {
        return areaDomainService.findAreaImagesForFeed(pageable).toList()
                .stream().map(AreaImageResponseDto::new).collect(Collectors.toList());
    }
}
