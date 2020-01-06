package liangliang.bigdata.repository;

import liangliang.bigdata.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
/**
 *@描述 无痕奈何
 *@创建人 彭亮
 */
public interface SupportAddressRepository extends CrudRepository<SupportAddress,Long> {
    /**
     * 获取所有对应行政级别的信息
     */
    List<SupportAddress> findAllByLevel(String level);
    SupportAddress findByEnNameAndLevel(String enName, String level);

    SupportAddress findByEnNameAndBelongTo(String enName, String belongTo);

    List<SupportAddress> findAllByLevelAndBelongTo(String level, String belongTo);
}
