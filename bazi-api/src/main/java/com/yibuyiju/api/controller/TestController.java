package com.yibuyiju.api.controller;

import com.yibuyiju.api.dto.TesterDTO;
import com.yibuyiju.api.dto.UserDTO;
import com.yibuyiju.api.entity.UserEntity;
import com.yibuyiju.api.mapstruct.UserConverter;
import com.yibuyiju.api.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/30 10:20
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String index() {
        log.error("xxxxxxxxxxxxxqqqqq{}", 000000666666);

        UserDTO userDTO = new UserDTO();
        userDTO.setPhone("xxxxxxxxxxxxx");
        userDTO.setUseragent("1111");

        UserEntity entity = UserConverter.INSTANCE.toEntity(userDTO);


        System.err.println("xxxxxxxxxxxxxxbbbbb");
        return "xxxxxxx";
    }


    @PostMapping("/test3")
    public Object save(@RequestBody TesterDTO test) {

        return test;
    }


    @PostMapping("/test1")
    public String index1(@RequestBody TesterDTO testerInfoDTO) {

        log.error("xxxxxxxxxxxx1111111x{}", testerInfoDTO);
        System.err.println(testerInfoDTO);
        return "xxxxxxx";

    }
}
