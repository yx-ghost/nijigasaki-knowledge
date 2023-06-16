package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "article_type")
public class ArticleType {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    @TableField(value ="article_id")
    private Long articleId;
    @TableField(value ="article_type_name")
    private String articleTypeName;
}
