package com.nijigasaki.knowledge.controller.user;

import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
import com.nijigasaki.knowledge.service.ServiceFactory;
import com.nijigasaki.knowledge.service.user.UserService;
import com.nijigasaki.knowledge.service.user.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "用户信息")
public class UserController {

    private UserService userService = ServiceFactory.getService(UserServiceImpl.class);
    @PostMapping("/login")
    @ApiOperation("登录")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password)  {
        return userService.doLogin(username,password);
    }

    private void test() {
        throw new BusinessException(BusinessError.DATA_NOT_FOUND);
    }
}
