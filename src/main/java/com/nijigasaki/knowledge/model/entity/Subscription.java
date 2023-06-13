package com.nijigasaki.knowledge.model.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Subscription {
    private Long id;
    private String username;
    private Long collectionId;
}
