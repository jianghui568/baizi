package com.yibuyiju.api.config;

import com.yibuyiju.api.config.auth.LoginingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/9 15:52
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LoginingInterceptor loginingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登录拦截
        registry.addInterceptor(loginingInterceptor)
                .addPathPatterns("/**");
    }

}
