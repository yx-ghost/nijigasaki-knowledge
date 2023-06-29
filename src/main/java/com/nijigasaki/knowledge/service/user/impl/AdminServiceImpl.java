package com.nijigasaki.knowledge.service.user.impl;

import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.JwtTokenUtil;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
import com.nijigasaki.knowledge.mapper.UserMapper;
import com.nijigasaki.knowledge.model.dto.UserLoginDTO;
import com.nijigasaki.knowledge.model.dto.UserRegisterDTO;
import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.model.vo.UserInfoVO;
import com.nijigasaki.knowledge.service.BaseService;
import com.nijigasaki.knowledge.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class AdminServiceImpl extends BaseService<UserMapper, User> implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public String doLogin(UserLoginDTO userLoginDTO) {
        // 1. 校验用户名密码是否正确
        User user = userMapper.checkLogin(userLoginDTO);
        // 2. 如果正确则生成token并返回
        if (Objects.isNull(user)) {
            throw new BusinessException(BusinessError.PASSWORD_ERROR);

        }
        return JwtTokenUtil.generateToken(userLoginDTO.getAdminId());
    }

    @Override
    public Boolean register(UserRegisterDTO userRegisterDTO) {
        return Boolean.FALSE;
    }

    @Override
    public Boolean editUserInfo(User user) {
        return null;
    }

    @Override
    public Boolean logout(String username) {
        return null;
    }

    @Override
    public UserInfoVO getUserInfo(String token) {
        return null;
    }
}
