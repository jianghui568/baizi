package com.yibuyiju.api.config.auth;

import com.yibuyiju.api.model.UserInfo;
import com.yibuyiju.api.entity.UserEntity;
import com.yibuyiju.api.service.UserService;
import com.yibuyiju.common.exception.JwtBizException;
import com.yibuyiju.common.threadlocal.BaseContext;
import com.yibuyiju.common.util.jwt.JwtUtil;
import com.yibuyiju.common.util.jwt.PayloadDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/9 15:12
 */
@Component
public class LoginingInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            final HandlerMethod handlerMethod = (HandlerMethod) handler;
            final Class<?> clazz = handlerMethod.getBeanType();
            final Method method = handlerMethod.getMethod();
            // 判断LoginAuth注解是标记在所调用的方法上还是在其类上
            if (clazz.isAnnotationPresent(Logining.class) || method.isAnnotationPresent(Logining.class)) {
                // 登录鉴权的主要业务逻辑解释是当发现用户没有做登陆的时候，立即抛出一个自定义的业务异常BusinessException，如果登录则return true继续执行后续代码。

                String bearerToken = request.getHeader("Authorization");
                if (Objects.isNull(bearerToken) || !bearerToken.startsWith("Bearer ")) {
                    throw new JwtBizException("token null");
                }

                String jwtToken = bearerToken.substring(7);

                PayloadDTO payload = JwtUtil.verifyToken(jwtToken);

                if (Objects.isNull(payload.getId())) {
                    throw new JwtBizException("token id null");
                }

                UserEntity user = userService.getByUserId(payload.getId());
                if (Objects.isNull(user)) {
                    throw new JwtBizException("user null");
                }

                UserInfo userInfo = new UserInfo();
                userInfo.setUser(user);
                BaseContext.setLoginUser(userInfo);
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // nothing to do
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // nothing to do
    }

}
