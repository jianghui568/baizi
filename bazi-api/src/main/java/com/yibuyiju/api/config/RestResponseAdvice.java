package com.yibuyiju.api.config;


import com.alibaba.fastjson2.JSON;
import com.yibuyiju.common.response.Response;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.swagger.web.ApiResourceController;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/10/26 17:37
 */
@RestControllerAdvice
public class RestResponseAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 判断Controller方法返回值是否支持
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        // 排除swagger相关的api
        String path = returnType.getExecutable().getDeclaringClass().getName();
        if (path.contains("swagger") || path.contains("Swagger")) {
            return false;
        }

        // 如果接口返回的类型本身就是Response那就没有必要进行额外的操作，返回false
        if (returnType.getGenericParameterType().equals(Response.class)) {
            return false;
        }

        // swagger
        if (returnType.getContainingClass().getName().equals("springfox.documentation.swagger.web.ApiResourceController")) {
            return false;
        }
        // 对类或者方法上面注解了@RestController 或者 @ResponseBody 的方法统一处理
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), RestController.class) || returnType.hasMethodAnnotation(ResponseBody.class);
    }

    /**
     * 当类或者方法使用了 @ResponseResultBody 就会调用这个方法
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);


        // 防止重复包裹的问题出现
        if (body instanceof Response) {
            return body;
        }
        if (body instanceof String || returnType.getGenericParameterType().equals(String.class)) {

            return JSON.toJSONString(Response.success(body));
        }
        return Response.success(body);
    }
}
