package snap.photographer.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import snap.common.dto.ImageReq;
import snap.common.dto.TagReq;
import snap.common.enums.SpecialKeyword;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class PhotographerCustomDto {
    private String nickname;
    private String profileImage;

    private String paymentImage;
    private Long lowestPay;
    private String bio;

    private List<Long> areaId;

    private SnsReq sns;

    private List<SpecialKeyword> specialList;

    private TagReq tag;

    private List<LocalDateTime> unableDates;

    private ImageReq image;
}
