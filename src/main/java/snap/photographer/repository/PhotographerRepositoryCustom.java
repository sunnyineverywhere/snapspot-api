package snap.photographer.repository;

import snap.photographer.entity.Photographer;
import snap.common.dto.PhotographerFilterReq;

import java.util.List;

public interface PhotographerRepositoryCustom {

    List<Photographer> searchAll(PhotographerFilterReq photographerFilterReq);
}
