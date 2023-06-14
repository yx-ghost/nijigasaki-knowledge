package com.nijigasaki.knowledge.model.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class GroupMember {
    private Long groupId;
    private String username;
}
