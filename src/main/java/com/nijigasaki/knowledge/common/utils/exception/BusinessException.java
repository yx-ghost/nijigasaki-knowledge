package com.nijigasaki.knowledge.common.utils.exception;

import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import org.springframework.web.bind.annotation.RestControllerAdvice;

public class BusinessException extends RuntimeException{
    private BusinessError businessError;

    public BusinessException(BusinessError businessError) {
        this.businessError = businessError;
    }

    public BusinessError getBusinessError() {
        return businessError;
    }

    public void setBusinessError(BusinessError businessError) {
        this.businessError = businessError;
    }
}
