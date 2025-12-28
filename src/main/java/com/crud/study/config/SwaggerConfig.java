package com.crud.study.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(apiInfo());
    }


    private Info apiInfo() {
        return new Info()
                .title("게시판 CRUD Swagger")
                .description("객체지향 적으로 코딩하기 (SOLID, AI 안쓰기)")
                .version("1.0.0");
    }
}
