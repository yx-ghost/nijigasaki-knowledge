package com.nijigasaki.knowledge.controller.user;

import com.nijigasaki.knowledge.model.dto.UserLoginDTO;
import com.nijigasaki.knowledge.service.ServiceFactory;
import com.nijigasaki.knowledge.service.user.UserService;
import com.nijigasaki.knowledge.service.user.impl.AdminServiceImpl;
import com.nijigasaki.knowledge.service.user.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("管理员")
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService = ServiceFactory.getService(AdminServiceImpl.class);
    @PostMapping("/login")
    @ApiOperation("登录")
    public String login(@RequestBody UserLoginDTO userLoginDTO)  {
        return userService.doLogin(userLoginDTO);
    }
}
