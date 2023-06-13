package com.nijigasaki.knowledge.common.enums.error;

import lombok.Getter;

public enum BusinessError {




    /**
     *  数据相关异常
     */
    DATA_NOT_FOUND("1000","数据未找到"),
    PARAM_CAN_NOT_EMPTY("1001","参数不能为空"),
    TIME_FORMAT_ERROR("1002","时间格式转换错误"),

    /**
     * 用户信息相关异常
     */
    PHONE_NUMBER_FORMAT_ERROR("2001","用户电话号码格式错误"),
    ;
    @Getter
    private String code;
    @Getter
    private String description;


    BusinessError(String code,String description ) {
        this.description = description;
        this.code = code;
    }
}
