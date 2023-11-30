package com.yibuyiju.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/30 14:36
 */
@SpringBootApplication(scanBasePackages = "com.yibuyiju.*")
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
