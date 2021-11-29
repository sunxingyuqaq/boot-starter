package com.boot.study.tests.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Xingyu Sun
 * @version 1.0
 * @date 2020/4/14 16:34
 * @apiNote swagger config
 * @see Object
 * @since jdk1.8
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any()).build();
    }
    
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("拾花酿春 RESTFUL API")
                .contact(new Contact("XingYu Sun","http://www.baidu.com","1287062155@qq.com"))
                .description("展示先做基础功能，后面再添加业务")
                .termsOfServiceUrl("https://www.baidu.com")
                .version("1.0")
                .build();
    }
}
