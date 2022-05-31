package com.message.sendmessage.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.config
 * @Author: GXW
 * @CreateTime: 2022-05-26  14:51
 * @Description: TODO
 * @Version: 1.0
 */
public class SwaggerConfig {
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("dome-api").description("邮件提醒服务").version("1.1.0").build();
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

    @Bean
    public Docket docket2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("测试接口") // 指定组名
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.message.sendmessage.controller")) // 指定扫描的包
                .paths(PathSelectors.ant("/test/**")) // 展示满足url格式的路径
                .build();
    }
}
