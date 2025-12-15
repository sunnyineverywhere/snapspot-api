package snap.photographer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import snap.photographer.entity.Photographer;
import snap.photographer.entity.Sns;
import snap.photographer.repository.SnsRepository;

@Service
@Transactional
@RequiredArgsConstructor
public class SnsDomainService {
    private final SnsRepository snsRepository;

    public void updateSns(Photographer photographer, String instagram, String twitter,
                          String kakaoChannel, String naverBlog, String homepage){
        Sns sns = photographer.getSns();
        sns.updateSns(instagram, twitter, kakaoChannel, naverBlog, homepage);
    }

    public void createSns(Photographer photographer) {
        snsRepository.save(
          Sns.builder().photographer(photographer).build()
        );
    }

}
