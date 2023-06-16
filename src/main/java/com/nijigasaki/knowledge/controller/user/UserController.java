package com.nijigasaki.knowledge.controller.user;

import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
import com.nijigasaki.knowledge.service.ServiceFactory;
import com.nijigasaki.knowledge.service.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/login")
    public String login()  {
        return "success";
    }

    private void test() {
        throw new BusinessException(BusinessError.DATA_NOT_FOUND);
    }
}
