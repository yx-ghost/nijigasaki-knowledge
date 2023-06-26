package com.nijigasaki.knowledge.service.article.impl;

import com.nijigasaki.knowledge.mapper.ArticleMapper;
import com.nijigasaki.knowledge.mapper.UserMapper;
import com.nijigasaki.knowledge.model.entity.Article;
import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.model.vo.ArticleRecommendVO;
import com.nijigasaki.knowledge.service.BaseService;
import com.nijigasaki.knowledge.service.article.ArticleService;
import com.nijigasaki.knowledge.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ArticleServiceImpl extends BaseService<ArticleMapper, Article> implements ArticleService {
    @Override
    public List<ArticleRecommendVO> recommend() {
        return null;
    }
}
