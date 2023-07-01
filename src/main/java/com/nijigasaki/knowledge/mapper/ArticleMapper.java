package com.nijigasaki.knowledge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nijigasaki.knowledge.model.entity.Article;
import com.nijigasaki.knowledge.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
