package com.nijigasaki.knowledge.service.user.impl;

import com.nijigasaki.knowledge.mapper.UserMapper;
import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.service.BaseService;
import com.nijigasaki.knowledge.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class UserServiceImpl extends BaseService<UserMapper, User> implements UserService {

    @Override
    public String doLogin(String username, String password) {
        return null;
    }
}
