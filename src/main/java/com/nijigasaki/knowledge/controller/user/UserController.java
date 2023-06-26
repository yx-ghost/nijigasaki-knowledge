package com.nijigasaki.knowledge.controller.user;

import com.nijigasaki.knowledge.controller.BaseController;
import com.nijigasaki.knowledge.model.dto.UserLoginDTO;
import com.nijigasaki.knowledge.model.dto.UserRegisterDTO;
import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.model.vo.UserInfoVO;
import com.nijigasaki.knowledge.service.ServiceFactory;
import com.nijigasaki.knowledge.service.user.UserService;
import com.nijigasaki.knowledge.service.user.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "用户信息")
public class UserController extends BaseController<User,UserService> {

    private UserService userService = ServiceFactory.getService(UserServiceImpl.class);
    @PostMapping("/login")
    @ApiOperation("登录")
    public String login(@RequestBody UserLoginDTO userLoginDTO)  {
        return userService.doLogin(userLoginDTO);
    }

    @GetMapping("/getUserInfo")
    @ApiOperation("获取用户相关数据")
    public UserInfoVO getUserInfo(@RequestHeader("Authorization") String token) {
        return userService.getUserInfo(token);
    }

    @PostMapping("/register")
    @ApiOperation("注册")
    public Boolean register(@RequestBody UserRegisterDTO userRegisterDTO) {
        return userService.register(userRegisterDTO);
    }

    @PostMapping("/editUserInfo")
    @ApiOperation("修改用户信息")
    public Boolean editUserInfo(@RequestBody User user) {
        return userService.editUserInfo(user);
    }

    @PostMapping("/logout")
    @ApiOperation("/注销")
    public Boolean logout(@RequestParam("username") String username) {
        return userService.logout(username);
    }


}
