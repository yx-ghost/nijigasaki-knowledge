package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@TableName(value = "`like`")
public class Like {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String username;
    @TableField(value = "article_id")
    private Long articleId;
    @TableField(value = "comment_id")
    private Long commentId;
    @TableField(value = "create_time")
    private LocalDateTime createTime;
    private Integer status;
}
