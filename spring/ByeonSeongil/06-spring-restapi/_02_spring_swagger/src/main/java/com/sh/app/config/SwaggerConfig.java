package com.sh.app.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
    
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(appInfo());
    }

    /**
     * /swagger-ui/index.html 접속시 노출될 api 문서 내용
     * @return
     */
    private Info appInfo() {
        return new Info()
                .title("User 관리 API")
                .description("ssg-java3에서 관리하는 User API 입니다.")
                .contact(new Contact().name("김동현").email("shqkel1863@gmail.com"))
                .version("1.0.0");

    }


}
