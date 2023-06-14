package com.nijigasaki.knowledge.model.entity;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class GroupChat {
    private Long id;
    private String username;
    private Long groupId;
    private String content;
    private LocalDateTime createTime;
}
