package com.nijigasaki.knowledge.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@TableName(value = "group_member")
public class GroupMember {
    @TableField(value = "group_id")
    private Long groupId;
    private String username;
}
