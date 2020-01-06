package liangliang.bigdata.repository;

        import liangliang.bigdata.entity.Subway;
        import org.springframework.data.repository.CrudRepository;

        import java.util.List;

/**
 *@描述 无痕奈何
 *@创建人 彭亮
 */
public interface SubwayRepository extends CrudRepository<Subway, Long>{
    List<Subway> findAllByCityEnName(String cityEnName);
}
