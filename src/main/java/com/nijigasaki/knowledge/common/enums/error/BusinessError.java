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
     * redis 相关异常
     */
    REDIS_SET_OBJECT_FAILED("1101","redis插入失败"),
    REDIS_EXPIRE_FAILED("1102","redis设置过期时间失败"),
    REDIS_GET_DATA_FAILED("1103","redis获取数据失败"),

    /**
     * 用户信息相关异常
     */
    PHONE_NUMBER_FORMAT_ERROR("2001","用户电话号码格式错误"),
    PHONE_NUMBER_EXIST("2002","电话号码已经被使用过"),
    PASSWORD_ERROR("2003","密码错误"),
    /**
     * 文章相关异常
     */
    ARTICLE_NOT_FOUND("2050","文章不存在"),

    /**
     * 枚举相关异常
     */
    VISIBILITY_NOT_FOUND("2100","错误的文章可见性"),
    ARTICLE_STATUS_NOT_FOUND("2101","错误的文章状态")
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
