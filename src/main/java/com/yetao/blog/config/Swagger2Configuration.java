package com.yetao.blog.config;

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
 * @author YETAO
 * @Description Swagger2配置
 * @date 2020/7/29 15:39
 */

@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    public static final String VERSION = "1.0";


    /**
     * 门户api，接口前缀：blog
     *
     * @return
     */
    @Bean
    public Docket portalApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(portalApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yetao.blog.controller.blog"))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build()
                .groupName("博客系统门户接口文档");
    }

    private ApiInfo portalApiInfo() {
        return new ApiInfoBuilder()
                .title("博客系统门户接口文档") //设置文档的标题
                .description("博客系统门户接口文档") // 设置文档的描述
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
                .build();
    }


    /**
     * 管理中心api，接口前缀：admin
     *
     * @return
     */
    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(adminApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yetao.blog.controller.admin"))
                .paths(PathSelectors.any()) // 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build()
                .groupName("博客管理中心接口文档");
    }


    private ApiInfo adminApiInfo() {
        return new ApiInfoBuilder()
                .title("博客管理中心接口文档") //设置文档的标题
                .description("博客管理中心接口文档") // 设置文档的描述
                .version(VERSION) // 设置文档的版本信息-> 1.0.0 Version information
                .build();
    }
}