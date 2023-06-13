package com.nijigasaki.knowledge.common.enums.basic;

import lombok.Getter;

public enum Visibility {
    PUBLIC(1,"公开"),
    PRIVATE(2,"私有"),
    GROUP(3,"仅群组成员可见"),
    FANS(4,"仅粉丝可见")
    ;

    @Getter
    private int code;
    @Getter
    private String description;

    Visibility(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
