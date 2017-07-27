package com.aisino.cloud.handler.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger配置
 * Created by fangxm on 2017-07-18.
 * access address: http://ip:port/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String VERSION = "3.0.0-SNAPSHOT";
    private static final String BASE_PACKAGE = "com.aisino.cloud.handler.controller";

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                //.paths(regex("/product.*"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "云记账在线API系统",
                null,
                VERSION,
                null,
                new Contact(null, null, null),
                null,
                null);
    }
}
