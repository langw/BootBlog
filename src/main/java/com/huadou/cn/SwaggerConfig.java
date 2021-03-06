package com.huadou.cn;

import com.huadou.cn.plateform.model.User;
import com.huadou.cn.plateform.model.UserInfo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by jinliang on 16/10/17.
 */

/**
 * swaggerConfig 之间的配置信息
 */
@Configurable
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).ignoredParameterTypes(User.class)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.huadou.cn.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("Boot  Blog ",//大标题
                "Spring boot + swagger + mybatis + druid",//小标题
                "1.0",//版本
                "NO terms of service",
                "jinliang",//作者
                "RayeBlog",//链接显示文字
                "http://www.raye.wang/"//网站链接
        );

        return apiInfo;
    }
}
