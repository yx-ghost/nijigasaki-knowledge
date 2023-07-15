package com.nijigasaki.knowledge.common.utils.algorithm.impl;

import com.nijigasaki.knowledge.common.utils.algorithm.ArticleRecommendAlgorithm;
import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.model.vo.ArticleRecommendVO;
import com.nijigasaki.knowledge.service.ServiceFactory;
import com.nijigasaki.knowledge.service.article.ArticleService;
import com.nijigasaki.knowledge.service.article.impl.ArticleServiceImpl;

import java.util.List;

public class ArticleRecommendAlgorithmImpl implements ArticleRecommendAlgorithm {
    @Override
    public List<ArticleRecommendVO> generateNotLoginArticles(Long lastArticleId) {
        // 1. 获取articleService
        ArticleService service = ServiceFactory.getService(ArticleServiceImpl.class);
        // 2. 根据算法得出排行榜
        return null;
    }

    @Override
    public List<ArticleRecommendVO> generateLoginArticles(User user, Long lastArticleId) {
        return null;
    }
}
