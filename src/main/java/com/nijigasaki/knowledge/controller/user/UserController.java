package com.nijigasaki.knowledge.controller.user;

import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/login")
    public String hello()  {
//        test();
        return "hello";
    }

    private void test() {
        throw new BusinessException(BusinessError.DATA_NOT_FOUND);
    }
}
