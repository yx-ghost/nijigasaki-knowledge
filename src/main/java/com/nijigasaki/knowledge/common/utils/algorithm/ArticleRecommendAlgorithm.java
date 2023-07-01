package com.nijigasaki.knowledge.common.utils.algorithm;

import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.model.vo.ArticleRecommendVO;

import java.util.List;

public interface ArticleRecommendAlgorithm {
    List<ArticleRecommendVO> generateNotLoginArticles(Long lastArticleId);

    List<ArticleRecommendVO> generateLoginArticles(User user,Long lastArticleId);
}
