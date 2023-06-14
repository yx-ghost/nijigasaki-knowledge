package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
//@TableName
public class Follow {
    private Long id;
    private String username;
    private String followName;
}
