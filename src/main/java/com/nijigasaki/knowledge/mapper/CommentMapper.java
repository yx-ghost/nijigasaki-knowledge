package com.nijigasaki.knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nijigasaki.knowledge.model.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
