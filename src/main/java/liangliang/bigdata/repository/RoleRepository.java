package liangliang.bigdata.repository;

import liangliang.bigdata.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//一个对应实体类，一个对应我们的id

/**
 *@描述 无痕奈何
 *@创建人 彭亮
 */
public interface RoleRepository extends CrudRepository<Role,Long> {
    List<Role> findRoleByUserId (Long userId);
}
