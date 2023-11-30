package com.yibuyiju.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/30 10:18
 */
@SpringBootApplication(scanBasePackages = "com.yibuyiju.*")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
