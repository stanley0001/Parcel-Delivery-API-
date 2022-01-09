package com.stan.parcel.Configurations.SecurityConfiguration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("com.stan.parcel")
                        .description("Alpha API")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://stan.co.ke")))
                .externalDocs(new ExternalDocumentation()
                        .description("Test Swagger environment")
                        .url("http://localhost/docs"));
    }

}
