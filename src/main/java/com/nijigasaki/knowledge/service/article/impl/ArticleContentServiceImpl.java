package com.nijigasaki.knowledge.service.article.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nijigasaki.knowledge.mapper.ArticleContentMapper;
import com.nijigasaki.knowledge.model.entity.ArticleContent;
import com.nijigasaki.knowledge.service.article.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;

public class ArticleContentServiceImpl implements ArticleContentService {
    @Autowired
    ArticleContentMapper articleContentMapper;
    @Override
    public ArticleContent findByArticleId(Long id) {
        QueryWrapper<ArticleContent> wrapper = Wrappers.query();
        wrapper.eq("article_id",id);
        return articleContentMapper.selectOne(wrapper);
    }
}
