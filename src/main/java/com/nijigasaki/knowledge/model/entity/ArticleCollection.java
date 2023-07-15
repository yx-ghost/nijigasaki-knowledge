package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.nijigasaki.knowledge.common.utils.SpringContextUtil;
import com.nijigasaki.knowledge.mapper.ArticleCollectionMapper;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName("article_collection")
public class ArticleCollection {
    private Long id;
    private String name;
    private String username;

    public static ArticleCollection getById(Long id) {
        ArticleCollectionMapper collectionMapper = SpringContextUtil.getBean(ArticleCollectionMapper.class);
        return collectionMapper.selectById(id);
    }
}
