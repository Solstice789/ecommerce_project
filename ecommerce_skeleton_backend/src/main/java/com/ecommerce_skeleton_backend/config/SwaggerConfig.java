package com.ecommerce_skeleton_backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI ecommerceOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Ecommerce Skeleton API")
                .description("API documentation for ecommerce skeleton backend")
                .version("v1"));
    }
}