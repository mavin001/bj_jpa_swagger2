package com.bjblackhole.bj_jpa_swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * ClassName:Swagger2
 * Package:com.bjblackhole.bj_jpa_swagger2.config
 * Description:
 *
 * @Date:2020/03/04 0004 14:34
 * @Author:mavin001@163.com
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket restApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bjblackhole.bj_jpa_swagger2"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("学校管理系统_接口文档")//Swagger界面标题
                .description("描述：学生管理模块、班级管理模块")//项目描述
                .termsOfServiceUrl("localhost:8000")
                .contact("Mavin")//创建人
                .version("1.0")//项目版本
                .build();
    }

}
