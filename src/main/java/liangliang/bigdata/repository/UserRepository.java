package liangliang.bigdata.repository;

import liangliang.bigdata.entity.User;
import org.springframework.data.repository.CrudRepository;
/**
 *@描述 无痕奈何
 *@创建人 彭亮
 */
//主键里的泛型是自己定义的User实体类，第二个是主键的类型

public interface UserRepository extends CrudRepository<User,Long> {
    //JPA自动帮我们生成sql语句
    User findByName(String UserName);
}
