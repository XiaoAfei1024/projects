package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Liao Feng
 * @Description //TODO
 * @Date 2019/10/15/015 10:40
 * @Version 1.0
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {
    @Bean
    public Docket projectCreationInfoApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(projectCreationInfo())
                .globalResponseMessage(RequestMethod.POST, customerResponseMessage())
                .globalResponseMessage(RequestMethod.GET, customerResponseMessage())
                .groupName("系统模块")
                .select()
                //扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo projectCreationInfo() {
        return new ApiInfoBuilder()
                .title("这是一个标题")
                .description("简单优雅的restfun风格")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
//    @Bean
//    public Docket createManagerRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .globalResponseMessage(RequestMethod.POST, customerResponseMessage())
//                .globalResponseMessage(RequestMethod.GET, customerResponseMessage())
//                .groupName("登录和用户管理")
//                .select()
//                //扫描的包
//                .apis(RequestHandlerSelectors.basePackage("com.szwg.timemanagementsystem.controller.manager"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("管理模块")
//                .description("简单优雅的restfun风格")
//                .termsOfServiceUrl("")
//                .version("1.0")
//                .build();
//    }
    private List<ResponseMessage> customerResponseMessage() {
        List<ResponseMessage> list = new ArrayList<>();
        list.add(new ResponseMessageBuilder().code(200).message("请求成功").build());
        list.add(new ResponseMessageBuilder().code(201).message("资源创建成功").build());
        list.add(new ResponseMessageBuilder().code(204).message("服务器成功处理了请求，但不需要返回任何实体内容").build());
        list.add(new ResponseMessageBuilder().code(400).message("请求失败,具体查看返回业务状态码与对应消息").build());
        list.add(new ResponseMessageBuilder().code(401).message("请求失败,未经过身份认证").build());
        list.add(new ResponseMessageBuilder().code(405).message("请求方法不支持").build());
        list.add(new ResponseMessageBuilder().code(415).message("请求媒体类型不支持").build());
        return list;
    }
}
