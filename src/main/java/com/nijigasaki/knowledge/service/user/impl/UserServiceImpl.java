package com.nijigasaki.knowledge.service.user.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nijigasaki.knowledge.common.consts.RedisConst;
import com.nijigasaki.knowledge.common.enums.basic.Status;
import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.JwtTokenUtil;
import com.nijigasaki.knowledge.common.utils.RedisUtil;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
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

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class UserServiceImpl extends BaseService<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public String doLogin(UserLoginDTO userLoginDTO) {
        // 1. 校验用户名密码是否正确
        User user = userMapper.checkLogin(userLoginDTO);
        // 2. 如果正确则生成token并返回
        if (Objects.isNull(user)) {
            throw new BusinessException(BusinessError.PASSWORD_ERROR);

        }
        return JwtTokenUtil.generateToken(userLoginDTO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean register(UserRegisterDTO userRegisterDTO) {
        // 1. 校验手机号是否已经使用过
        String phone = userRegisterDTO.getPhone();
        QueryWrapper<User> wrapper = Wrappers.query();
        wrapper.eq("phone",phone);
        User one = getOne(wrapper);
        if (Objects.nonNull(one)) {
            throw new BusinessException(BusinessError.PHONE_NUMBER_EXIST);
        }
        // 2. 生成一个对应的User实体类进行插入
        User user = userRegisterDTO.convertToUser();
        save(user);
        System.out.println(user);
        return Boolean.TRUE;
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
        wrapper.eq("status", Status.ACTIVE.getCode()).eq("phone",phone);
        User user = getOne(wrapper);

        UserInfoVO userInfoVO = new UserInfoVO(user);
        userInfoVO.setToken(token);
        // todo 其他相关信息

        // 3. 存入threadLocal或者redis中
        String userInfoKey = RedisConst.USER_INFO_KEY;
        userInfoKey += token;
        try {
            redisUtil.setObject(userInfoKey,userInfoVO);
            redisUtil.expire(userInfoKey,7, TimeUnit.DAYS);
        } catch (Exception e) {
            throw new BusinessException(BusinessError.REDIS_SET_OBJECT_FAILED);
        }
        return userInfoVO;
    }
}
