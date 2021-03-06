package com.bjblackhole.bj_jpa_swagger2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
public class BjJpaSwagger2Application {

    public static void main(String[] args) {
        SpringApplication.run(BjJpaSwagger2Application.class, args);
    }



}
