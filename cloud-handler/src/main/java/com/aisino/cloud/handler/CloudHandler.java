package com.aisino.cloud.handler;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 请求处理服务入口
 * Created by fangxm on 2017-07-17.
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.aisino.cloud")
public class CloudHandler {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(CloudHandler.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
