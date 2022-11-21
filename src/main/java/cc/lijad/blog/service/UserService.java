package cc.lijad.blog.service;

import cc.lijad.blog.domain.LoginUser;
import cc.lijad.blog.domain.entity.User;

/**
 * @author 李坚达
 * @create 2022/11/14 14:50
 */
public interface UserService {

    /**
     * 登录
     * @param user
     * @return
     */
    LoginUser login(User user);
}
