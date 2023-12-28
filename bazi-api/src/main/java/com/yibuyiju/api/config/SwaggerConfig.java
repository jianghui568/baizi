package com.yibuyiju.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yjh
 * @version 1.0
 * @date 2023/11/17 16:45
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // apiInfo对象主要是设置我们api文档的标题，描述，访问的地址，创建者等信息
    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 页面标题
                .title("RESTful API")
                // 版本号
                .version("1.0")
                // 描述
                .description("RESTful API").build();
    }

    // docket容器设置我们的文档基础信息，api包的位置，以及路径的匹配规则（包含四种：全匹配，不匹配，正则匹配和ant匹配）
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yibuyiju.api.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(this.getParameterList())
                .securityContexts(securityContexts());// 全局配置
    }

    private List<SecurityContext> securityContexts() {
        List<SecurityContext> myList = new ArrayList<>();
        myList.add(SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("^(?!auth).*$")).build());
        return myList;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> list = new ArrayList<>();
        list.add(new SecurityReference("Authorization", authorizationScopes));
        return list;
    }

    /**
     * 添加head参数配置
     */
    private List<Parameter> getParameterList() {
        ParameterBuilder clientIdTicket = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        clientIdTicket.name("Authorization").description("token令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build(); // 设置false，表示clientId参数 非必填,可传可不传！
        pars.add(clientIdTicket.build());
        return pars;
    }
}
