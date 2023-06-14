package com.nijigasaki.knowledge.common.utils.webutils;

import com.alibaba.fastjson.JSONObject;
import com.nijigasaki.knowledge.common.enums.error.BusinessError;
import com.nijigasaki.knowledge.common.utils.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Objects;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    private static final Logger log = LoggerFactory.getLogger(ResponseAdvice.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        log.info("响应成功,响应时间:{},响应内容:{}", LocalDateTime.now(),body);
        int statusCode = ((ServletServerHttpResponse) response).getServletResponse().getStatus();
        if (statusCode == HttpStatus.NOT_FOUND.value()) {
            // 处理404错误，返回自定义的错误信息
            return Result.error("404","资源不存在");
        } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            // 处理500错误，返回自定义的错误信息
            return Result.error("500","服务器内部错误");
        }
        if (body instanceof Result) {
            return body;
        } else if (Objects.isNull(body)) {
            return Result.success();
        } else if (body instanceof String) {
            return JSONObject.toJSONString(Result.success(body));
        }  else {
            return Result.success(body);
        }
    }
}
