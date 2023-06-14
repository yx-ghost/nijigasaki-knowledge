package com.nijigasaki.knowledge.model.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ArticleCollection {
    private Long id;
    private String name;
    private String username;
}
