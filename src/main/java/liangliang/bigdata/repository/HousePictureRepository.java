package liangliang.bigdata.repository;

import liangliang.bigdata.entity.HousePicture;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *@描述 无痕奈何
 *@创建人 彭亮
 */
public interface HousePictureRepository extends CrudRepository<HousePicture, Long> {
    List<HousePicture> findAllByHouseId(Long id);
}
