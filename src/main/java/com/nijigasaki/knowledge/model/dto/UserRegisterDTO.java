package com.nijigasaki.knowledge.model.dto;

import com.nijigasaki.knowledge.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRegisterDTO {
    private String username;
    private String password;
    private String phone;

    public User convertToUser(){
        User user = new User();
        BeanUtils.copyProperties(this,user);
        user.setNickname("User" + System.currentTimeMillis());
        return user;
    }
}
