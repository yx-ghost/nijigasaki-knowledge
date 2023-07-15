package com.nijigasaki.knowledge.service.article.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nijigasaki.knowledge.common.consts.RedisConst;
import com.nijigasaki.knowledge.common.enums.basic.ArticleStatus;
import com.nijigasaki.knowledge.common.enums.basic.Status;
import com.nijigasaki.knowledge.common.enums.basic.Visibility;
import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.RedisUtil;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
import com.nijigasaki.knowledge.mapper.ArticleMapper;
import com.nijigasaki.knowledge.model.entity.Article;
import com.nijigasaki.knowledge.model.entity.ArticleCollection;
import com.nijigasaki.knowledge.model.entity.ArticleContent;
import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.model.vo.ArticleInfoVO;
import com.nijigasaki.knowledge.model.vo.ArticleRecommendVO;
import com.nijigasaki.knowledge.model.vo.UserInfoVO;
import com.nijigasaki.knowledge.service.BaseService;
import com.nijigasaki.knowledge.service.ServiceFactory;
import com.nijigasaki.knowledge.service.article.ArticleContentService;
import com.nijigasaki.knowledge.service.article.ArticleService;
import com.nijigasaki.knowledge.service.article.FavoriteService;
import com.nijigasaki.knowledge.service.article.LikeService;
import com.nijigasaki.knowledge.service.message.CommentService;
import com.nijigasaki.knowledge.service.message.impl.CommentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;



@Slf4j
@Service
public class ArticleServiceImpl extends BaseService<ArticleMapper, Article> implements ArticleService {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    LikeService likeService;
    @Autowired
    FavoriteService favoriteService;
    @Autowired
    CommentService commentService;
    @Autowired
    ArticleContentService articleContentService;
    @Override
    public List<ArticleRecommendVO> recommend(String token, Long lastArticleId) {
        // 1. 获取用户是否登录过
        String userInfoKey = RedisConst.USER_INFO_KEY;
        userInfoKey += token;
        User user = null;
        if (redisUtil.exist(userInfoKey)) {
            UserInfoVO userInfoVO = redisUtil.getObject(userInfoKey, UserInfoVO.class);
            user = userInfoVO.convertToUser();
        }
        boolean ifLogin = Objects.nonNull(user);
        // 2. 如果没登陆，按照系统算法生成文章推荐,生成20条文章，并将id存入Redis，之后每次取10条出来
        if (!ifLogin) {
            // 2.1 通过SQL查询出全量的数据，交由算法筛选出其中的文章信息并返回
            return getUnLoginRecommend(lastArticleId);
        }
        // 3. 如果登录过，按照用户画像生成文章推荐
        return getLoginRecommend(user,lastArticleId);
    }

    private List<ArticleRecommendVO> getLoginRecommend(User user, Long lastArticleId) {
        return null;
    }

    private List<ArticleRecommendVO> getUnLoginRecommend(Long lastArticleId) {
        // 如果已经redis中已经存在数据了，那么只需要按顺序返回文章即可
        String idKey = RedisConst.ARTICLE_RECOMMEND_NOT_LOGIN_ID_LIST;
        if (redisUtil.exist(idKey)) {
            List<Long> idList = redisUtil.getList(idKey, Long.class, lastArticleId, 10);
            // 并调用事件发布方法生成新的10条文章数据补充到redis中

            //
            String key = RedisConst.ARTICLE_RECOMMEND_NOT_LOGIN_LIST;
            return redisUtil.getMap(key, Collections.singleton(idList), ArticleRecommendVO.class);
        }
        // 如果没有，就调用算法生成20条文章记录并返回，之后存入redis中
        return null;
    }

    @Override
    public ArticleInfoVO getArticleInfo(Long id) {
        // 1. 获取文章信息
        QueryWrapper<Article> wrapper = Wrappers.query();
        wrapper.eq("id",id)
                .eq("status", Status.ACTIVE.getCode())
                .eq("article_status", ArticleStatus.APPROVED.getCode());
        Article article = articleMapper.selectOne(wrapper);
        if (Objects.isNull(article)) {
            throw new BusinessException(BusinessError.ARTICLE_NOT_FOUND);
        }
        ArticleInfoVO articleInfoVO = new ArticleInfoVO();
        BeanUtils.copyProperties(article,articleInfoVO,"articleStatus","visibility");
        articleInfoVO.setVisibility(article.getVisibility());
        articleInfoVO.setArticleStatus(article.getArticleStatus());
        ArticleContent articleContent = articleContentService.findByArticleId(id);
        if (Objects.isNull(articleContent)) {
            throw new BusinessException(BusinessError.ARTICLE_NOT_FOUND);
        }
        articleInfoVO.setContent(articleContent.getContent());
        // 2. 获取点赞信息
        Long likeCount = likeService.countByArticleId(id);
        articleInfoVO.setLikes(likeCount);
        // 3. 获取收藏数量
        Long favoriteCount = favoriteService.countByArticleId(id);
        articleInfoVO.setFavorites(favoriteCount);
        // 4. 获取评论数量
        Long commentCount = commentService.countByArticleId(id);
        articleInfoVO.setComments(commentCount);
        // 5. 获取合集名称
        ArticleCollection articleCollection = ArticleCollection.getById(id);
        if (Objects.nonNull(articleCollection)) {
            articleInfoVO.setCollectionName(articleCollection.getName());
        }

        return articleInfoVO;
    }
}
