package cc.lijad.blog.service.impl;

import cc.lijad.blog.dao.UserMapper;
import cc.lijad.blog.domain.LoginUser;
import cc.lijad.blog.domain.entity.User;
import cc.lijad.blog.exception.LoginException;
import cc.lijad.blog.service.UserService;
import cc.lijad.blog.service.web.TokenService;
import cc.lijad.blog.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 李坚达
 * @create 2022/11/14 14:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TokenService tokenService;

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional
    public LoginUser login(User user) {
        if (StringUtils.isNotBlank(user.getUsername()) && StringUtils.isNotBlank(user.getPassword())) {
            User dbUser = userMapper.loginUser(user);
            LoginUser loginUser = new LoginUser();
            if (dbUser != null) {
                //登录成功
                BeanUtils.copyProperties(dbUser, loginUser);
                Map<String, Object> playload = new HashMap<>();
                playload.put("userId", dbUser.getId());
                playload.put("username", dbUser.getUsername());
                String token = tokenService.createToken(playload);
                loginUser.setToken(token);
                return loginUser;
            } else {
                throw new LoginException("登录失败,用户名或密码错误");
            }
        }
        throw new LoginException("登录失败,用户名或密码不能为空");
    }
}
