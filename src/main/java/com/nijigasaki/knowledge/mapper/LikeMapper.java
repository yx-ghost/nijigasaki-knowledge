package com.nijigasaki.knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nijigasaki.knowledge.model.entity.Like;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper extends BaseMapper<Like> {
}
