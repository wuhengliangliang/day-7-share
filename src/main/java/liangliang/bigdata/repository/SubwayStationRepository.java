package liangliang.bigdata.repository;

import liangliang.bigdata.entity.SubwayStation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *@描述 无痕奈何
 *@创建人 彭亮
 */
public interface SubwayStationRepository extends CrudRepository<SubwayStation, Long> {
    List<SubwayStation> findAllBySubwayId(Long subwayId);
}
