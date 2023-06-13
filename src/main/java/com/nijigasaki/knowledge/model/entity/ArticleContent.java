package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
//@TableName
public class ArticleContent {
    private Long articleId;
    private String content;
}
