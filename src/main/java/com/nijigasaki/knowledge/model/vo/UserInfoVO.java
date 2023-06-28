package com.nijigasaki.knowledge.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.nijigasaki.knowledge.model.entity.Article;
import com.nijigasaki.knowledge.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

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



    public UserInfoVO(User user){
        BeanUtils.copyProperties(user,this);
    }

    public UserInfoVO convert(Article article) {

        return this;
    }
}
