package liangliang.bigdata.repository;

import liangliang.bigdata.entity.HouseDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *@描述 无痕奈何
 *@创建人 彭亮
 */
public interface HouseDetailRepository extends CrudRepository<HouseDetail, Long>{
    HouseDetail findByHouseId(Long houseId);

    List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);
}
