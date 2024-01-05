package com.yibuyiju.api.controller;

import com.yibuyiju.api.dto.UserDTO;
import com.yibuyiju.api.service.UserService;
import com.yibuyiju.common.exception.VerifyBizException;
import com.yibuyiju.common.util.ClientUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yjh
 * @version 1.0
 * @date 2024/1/4 14:50
 */
@Api(value = "登录")
@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/auth/login")
    public void login(@RequestBody @Valid UserDTO user) {
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            throw new VerifyBizException("两次密码输入不一致");
        }

        user.setUseragent(ClientUtil.getUserAgent());
        user.setIp(ClientUtil.getIpAddr());

        userService.login(user);
    }
}
