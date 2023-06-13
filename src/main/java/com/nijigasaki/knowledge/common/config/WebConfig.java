package com.nijigasaki.knowledge.common.config;

import com.nijigasaki.knowledge.common.interceptor.AdminInterceptor;
import com.nijigasaki.knowledge.common.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/**");
    }
}
