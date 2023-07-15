package com.nijigasaki.knowledge.service.message.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.nijigasaki.knowledge.common.enums.basic.Status;
import com.nijigasaki.knowledge.mapper.CommentMapper;
import com.nijigasaki.knowledge.model.entity.Comment;
import com.nijigasaki.knowledge.service.message.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public Long countByArticleId(Long id) {
        QueryWrapper<Comment> wrapper = Wrappers.query();
        wrapper.eq("article_id",id);
        return commentMapper.selectCount(wrapper);
    }
}
