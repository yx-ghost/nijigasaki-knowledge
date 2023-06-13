package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
//@TableName
public class Like {
    private Long id;
    private String username;
    private Long articleId;
    private Long commentId;
    private LocalDateTime createTime;
    private Integer status;
}
