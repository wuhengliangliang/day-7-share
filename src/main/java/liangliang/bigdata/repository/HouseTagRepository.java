package liangliang.bigdata.repository;

import liangliang.bigdata.entity.HouseTag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *@描述 无痕奈何
 *@创建人 彭亮
 */
public interface HouseTagRepository extends CrudRepository<HouseTag, Long> {
    HouseTag findByNameAndHouseId(String name, Long houseId);

    List<HouseTag> findAllByHouseId(Long id);

    List<HouseTag> findAllByHouseIdIn(List<Long> houseIds);
}
