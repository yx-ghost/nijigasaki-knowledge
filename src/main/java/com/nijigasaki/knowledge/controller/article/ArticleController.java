package com.nijigasaki.knowledge.controller.article;

import com.nijigasaki.knowledge.model.vo.ArticleInfoVO;
import com.nijigasaki.knowledge.model.vo.ArticleRecommendVO;
import com.nijigasaki.knowledge.service.ServiceFactory;
import com.nijigasaki.knowledge.service.article.ArticleService;
import com.nijigasaki.knowledge.service.article.impl.ArticleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@Api("文章信息")
public class ArticleController {
    private ArticleService articleService = ServiceFactory.getService(ArticleServiceImpl.class);

    @GetMapping("/recommend")
    @ApiOperation("获取首页推荐文章")
    public List<ArticleRecommendVO> recommend(@RequestHeader(value = "Authorization",required = false)String token,
                                              Long lastArticleId) {
        return articleService.recommend(token,lastArticleId);
    }

    @GetMapping("/article/{id}")
    @ApiOperation("进入文章详细页面")
    public ArticleInfoVO getArticleInfo(@PathVariable("id")Long id) {
        return articleService.getArticleInfo(id);
    }
}
