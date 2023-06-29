package com.nijigasaki.knowledge.service.article.impl;

import com.nijigasaki.knowledge.common.consts.RedisConst;
import com.nijigasaki.knowledge.common.utils.RedisUtil;
import com.nijigasaki.knowledge.mapper.ArticleMapper;
import com.nijigasaki.knowledge.model.entity.Article;
import com.nijigasaki.knowledge.model.entity.User;
import com.nijigasaki.knowledge.model.vo.ArticleInfoVO;
import com.nijigasaki.knowledge.model.vo.ArticleRecommendVO;
import com.nijigasaki.knowledge.model.vo.UserInfoVO;
import com.nijigasaki.knowledge.service.BaseService;
import com.nijigasaki.knowledge.service.article.ArticleService;
import lombok.extern.slf4j.Slf4j;
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
        return null;
    }
}
