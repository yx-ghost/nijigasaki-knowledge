package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "subscription")
public class Subscription {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String username;
    @TableField(value = "collection_id")
    private Long collectionId;
}
