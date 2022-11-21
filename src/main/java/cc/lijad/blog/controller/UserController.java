package cc.lijad.blog.controller;

import cc.lijad.blog.domain.AjaxResult;
import cc.lijad.blog.domain.LoginUser;
import cc.lijad.blog.domain.constant.Constants;
import cc.lijad.blog.domain.entity.User;
import cc.lijad.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李坚达
 * @create 2022/11/14 15:11
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user/login")
    public AjaxResult login(User user) {
        LoginUser loginUser = userService.login(user);
        return AjaxResult.success(loginUser).put(Constants.TOKEN, loginUser.getToken());
    }
}
