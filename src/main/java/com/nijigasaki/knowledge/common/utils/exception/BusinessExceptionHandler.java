package com.nijigasaki.knowledge.common.utils.exception;

import com.nijigasaki.knowledge.common.utils.webutils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    public Result handlerBusinessException(BusinessException businessException) {
        Result result = new Result();
        result.setData(businessException.getBusinessError().getDescription());
        result.setStatus(businessException.getBusinessError().getCode());
        result.setMessage("请求出错");
        return result;
    }



}
