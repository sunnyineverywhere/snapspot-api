package snap.photographer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snap.photographer.entity.Photographer;
import snap.photographer.entity.PhotographerTag;
import snap.photographer.repository.PhotographerTagRepository;
import snap.common.dto.TagReq;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class PhotographerTagDomainService {

    private final PhotographerTagRepository photographerTagRepository;

    @Transactional(readOnly = true)
    public List<Photographer> findPhotographerListByTag(String tag){

        return photographerTagRepository.findAllByTag1OrTag2OrTag3(tag, tag, tag)
                .stream().map(PhotographerTag::getPhotographer).toList();

    }
    public void createPhotographer(Photographer photographer) {
        photographerTagRepository.save(
                PhotographerTag.builder().photographer(photographer).build()
        );
    }

    public void updateTag(Photographer photographer, TagReq tag) {
        photographer.getTags().update(tag);
    }
}
