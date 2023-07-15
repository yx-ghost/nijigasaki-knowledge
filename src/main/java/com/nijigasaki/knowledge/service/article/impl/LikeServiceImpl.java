package com.nijigasaki.knowledge.service.article.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nijigasaki.knowledge.common.enums.basic.Status;
import com.nijigasaki.knowledge.mapper.LikeMapper;
import com.nijigasaki.knowledge.model.entity.Like;
import com.nijigasaki.knowledge.service.article.LikeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LikeServiceImpl  implements LikeService {
    @Autowired
    LikeMapper likeMapper;

    @Override
    public Long countByArticleId(Long id) {
        QueryWrapper<Like> wrapper = Wrappers.query();
        wrapper.eq("article_id",id)
                .eq("status", Status.ACTIVE.getCode());
        return likeMapper.selectCount(wrapper);
    }
}
