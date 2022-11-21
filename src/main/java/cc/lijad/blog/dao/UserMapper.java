package cc.lijad.blog.dao;

import cc.lijad.blog.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 李坚达
 * @create 2022/11/14 14:33
 */
@Mapper
public interface UserMapper {

    /**
     * 登录
     * @param user
     * @return
     */
    User loginUser(User user);

}
