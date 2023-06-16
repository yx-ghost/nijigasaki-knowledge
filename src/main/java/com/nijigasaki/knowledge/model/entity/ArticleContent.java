package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "article_content")
public class ArticleContent {
    @TableField("article_id")
    private Long articleId;
    private String content;
}
