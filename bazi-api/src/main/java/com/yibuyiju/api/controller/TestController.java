package com.yibuyiju.api.controller;

import com.yibuyiju.api.dto.TesterInfoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/30 10:20
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/test")
    public String index() {
        log.error("xxxxxxxxxxxxx{}", 000000000000);
        System.err.println("xxxxxxxxxxxxxx");
        return "xxxxxxx";
    }


    @PostMapping("/test1")
    public String index1(@RequestBody TesterInfoDTO testerInfoDTO) {

        log.error("xxxxxxxxxxxx1111111x{}", testerInfoDTO);
        System.err.println(testerInfoDTO);
        return "xxxxxxx";

    }
}
