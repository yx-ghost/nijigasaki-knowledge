package com.nijigasaki.knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nijigasaki.knowledge.model.dto.UserLoginDTO;
import com.nijigasaki.knowledge.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User checkLogin(@Param("userLoginDTO") UserLoginDTO userLoginDTO);
}
