package com.nijigasaki.knowledge.common.enums.basic;

import lombok.Getter;

public enum ArticleStatus {
    DRAFT(0,"草稿"),
    TO_BE_REVIEWED(1,"待审核"),
    APPROVED(2,"审核通过"),
    FAILED(3,"审核不通过");
    @Getter
    private int code;
    @Getter
    private String description;

    ArticleStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ArticleStatus findByCode(int code) {
        ArticleStatus[] values = ArticleStatus.values();
        for (ArticleStatus value : values) {
            if (value.code == code) {
                return value;
            }
        }
        return null;
    }
}
