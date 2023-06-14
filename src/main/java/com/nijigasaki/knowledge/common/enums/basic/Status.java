package com.nijigasaki.knowledge.common.enums.basic;

import lombok.Getter;

public enum Status {
    ACTIVE(1,"数据正常使用"),
    INACTIVE(0,"数据已删除")
    ;

    Status(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Getter
    private int code;
    @Getter
    private String description;
}
