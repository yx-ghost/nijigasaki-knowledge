package com.nijigasaki.knowledge.common.enums.basic;

import lombok.Getter;

public enum SendStatus {
    UNREAD(0,"未读"),
    READ(1,"已读");
    @Getter
    private int code;
    @Getter
    private String description;

    SendStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }
    public static SendStatus findByCode(Integer code) {
        SendStatus[] sendStatuses = SendStatus.values();
        for (SendStatus sendStatus : sendStatuses) {
            if (sendStatus.getCode() == code) {
                return sendStatus;
            }
        }
        return null;
    }
}
