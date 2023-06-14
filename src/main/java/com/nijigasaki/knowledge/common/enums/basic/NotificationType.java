package com.nijigasaki.knowledge.common.enums.basic;

import lombok.Getter;
import org.springframework.util.NumberUtils;

public enum NotificationType {
    AUDIT(0,"审核结果"),
    ACTIVITY_ADVISORY(1,"活动通知"),
    SYSTEM_ADVISORY(2,"系统通知")
    ;
    @Getter
    private int code;
    @Getter
    private String description;

    NotificationType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static NotificationType findByCode(Integer code) {
        NotificationType[] notificationTypes = NotificationType.values();
        for (NotificationType notificationType : notificationTypes) {
            if (notificationType.getCode() == code) {
                return notificationType;
            }
        }
        return null;
    }
}
