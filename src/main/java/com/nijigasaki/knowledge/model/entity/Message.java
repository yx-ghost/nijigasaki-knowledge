package com.nijigasaki.knowledge.model.entity;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Message {
    private Long id;
    private String username;
    private String sendName;
    private String content;
    private LocalDateTime createTime;
}
