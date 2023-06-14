package com.nijigasaki.knowledge.model.entity;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@ToString
public class Comment {
    private Long id;
    private String username;
    private Long articleId;
    private String content;
    private Long parentId;
    private LocalDateTime createTime;
}
