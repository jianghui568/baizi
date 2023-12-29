package com.yibuyiju.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/30 10:18
 */

@SpringBootApplication(scanBasePackages = "com.yibuyiju.*")
public class ApiApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApiApplication.class, args);
        ConfigurableEnvironment env = context.getEnvironment();

        String port = env.getProperty("server.port");
        String swaggerUrl = port + "/swagger-ui.html";
        System.err.println("================================= \r\n" +
                "=========== swagger url: " + swaggerUrl + " \r\n" +
                "========================================");
    }
}
