package com.nijigasaki.knowledge.model.entity;

import com.nijigasaki.knowledge.common.enums.basic.NotificationType;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@ToString
public class Notification {
    private Long id;
    private String username;
    private Integer type;
    private String content;
    private LocalDateTime createTime;

    public String getTypeDesc() {
        NotificationType notificationType = NotificationType.findByCode(type);
        if (Objects.isNull(notificationType)) {
            return "";
        }
        return notificationType.getDescription();
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public void setType(NotificationType notificationType) {
        this.type = notificationType.getCode();
    }
}
