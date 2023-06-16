package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.AESUtil;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@TableName(value = "user")
public class User extends BaseEntity{
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String avatar;
    private String signature;
    @TableField(value = "space_cover")
    private String spaceCover;
    @TableField(value = "is_admin")
    private Boolean isAdmin = Boolean.FALSE;

    public void setPassword(String password) {
        this.password = AESUtil.encrypt(password);
        System.out.println(this.password);
    }

    public String getPassword() {
        return AESUtil.decrypt(password);
    }

    public void setPhone(String phone) {
        String PHONE_REGEX = "^1[3456789]\\d{9}$";
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) {
            this.phone = phone;
        } else {
            throw new BusinessException(BusinessError.PHONE_NUMBER_FORMAT_ERROR);
        }
    }
}
