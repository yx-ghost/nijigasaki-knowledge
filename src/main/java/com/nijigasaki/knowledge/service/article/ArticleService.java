package com.nijigasaki.knowledge.service.article;

import com.nijigasaki.knowledge.model.vo.ArticleInfoVO;
import com.nijigasaki.knowledge.model.vo.ArticleRecommendVO;

import java.util.List;

public interface ArticleService {
    List<ArticleRecommendVO> recommend();

    ArticleInfoVO getArticleInfo(Long id);
}
