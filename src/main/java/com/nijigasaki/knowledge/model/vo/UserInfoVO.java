package com.nijigasaki.knowledge.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoVO {
    private String username;
    private String nickname;
    private String phone;
    private String avatar;
    private String signature;
    private String spaceCover;
    private String token;

    // 文章相关数据
    private Integer articles;
    private Integer likes;

    // 动态相关数据

}
