package com.nijigasaki.knowledge.model.entity;

import com.nijigasaki.knowledge.common.enums.basic.SendStatus;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@ToString
public class Chat {
    private Long id;
    private String sendName;
    private String receiveName;
    private String content;
    private LocalDateTime sendTime;
    private Integer sendStatus;

    public void setSendStatus(Integer sendStatus) {
        this.sendStatus = sendStatus;
    }

    public void setSendStatus(SendStatus sendStatus) {
        this.sendStatus = sendStatus.getCode();
    }

    public String getSendStatusDesc() {
        SendStatus status = SendStatus.findByCode(sendStatus);
        if (Objects.isNull(status)) {
            return "";
        }
        return status.getDescription();
    }

}
