package com.nijigasaki.knowledge.service.article;

import com.nijigasaki.knowledge.model.entity.ArticleContent;

public interface ArticleContentService {
    ArticleContent findByArticleId(Long id);
}
