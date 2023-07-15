package com.nijigasaki.knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nijigasaki.knowledge.model.entity.ArticleCollection;
import com.nijigasaki.knowledge.model.entity.Like;
import org.apache.ibatis.annotations.Mapper;

import java.util.AbstractCollection;

@Mapper
public interface ArticleCollectionMapper extends BaseMapper<ArticleCollection> {
}
