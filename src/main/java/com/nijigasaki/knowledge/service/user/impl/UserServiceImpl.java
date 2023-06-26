package com.nijigasaki.knowledge.service.user.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nijigasaki.knowledge.common.utils.JwtTokenUtil;
import com.nijigasaki.knowledge.mapper.UserMapper;
import com.nijigasaki.knowledge.model.dto.UserLoginDTO;
import com.nijigasaki.knowledge.model.dto.UserRegisterDTO;
import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.model.vo.UserInfoVO;
import com.nijigasaki.knowledge.service.BaseService;
import com.nijigasaki.knowledge.service.user.UserService;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl extends BaseService<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public String doLogin(UserLoginDTO userLoginDTO) {
        // 1. 校验用户名密码是否正确
        // 2. 存放用户信息到redis中(或threadLocal中)
        // 3. 如果正确则生成token并返回
        String token = JwtTokenUtil.generateToken(userLoginDTO);
        return token;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(UserRegisterDTO userRegisterDTO) {
        // 1. 校验手机号是否已经使用过
        // 2. 生成一个对应的User实体类进行插入
        User user = userRegisterDTO.convertToUser();
        System.out.println(user);
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean editUserInfo(User user) {
        return null;
    }

    @Override
    public Boolean logout(String username) {
        return null;
    }

    @Override
    public UserInfoVO getUserInfo(String token) {
        // 1. 从token中解析出用户信息
        String phone = JwtTokenUtil.getClaimFromToken(token, Claims::getSubject);
        // 2. 根据phone去查询相关数据
        QueryWrapper<User> wrapper = Wrappers.query();
        return null;
    }
}
