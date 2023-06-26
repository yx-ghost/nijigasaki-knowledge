package com.nijigasaki.knowledge.controller.article;

import com.nijigasaki.knowledge.model.vo.ArticleRecommendVO;
import com.nijigasaki.knowledge.service.ServiceFactory;
import com.nijigasaki.knowledge.service.article.ArticleService;
import com.nijigasaki.knowledge.service.article.impl.ArticleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
@Api("文章信息")
public class ArticleController {
    private ArticleService articleService = ServiceFactory.getService(ArticleServiceImpl.class);

    @GetMapping("/recommend")
    @ApiOperation("获取首页推荐文章")
    public List<ArticleRecommendVO> recommend() {
        return articleService.recommend();
    }
}
