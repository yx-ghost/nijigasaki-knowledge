package com.nijigasaki.knowledge.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nijigasaki.knowledge.model.dto.UserLoginDTO;
import com.nijigasaki.knowledge.model.dto.UserRegisterDTO;
import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.model.vo.UserInfoVO;

public interface UserService extends IService<User> {
    String doLogin(UserLoginDTO userLoginDTO);

    Boolean register(UserRegisterDTO userRegisterDTO);

    Boolean editUserInfo(User user);

    Boolean logout(String username);

    UserInfoVO getUserInfo(String token);
}
