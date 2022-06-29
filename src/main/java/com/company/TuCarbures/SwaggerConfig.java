package com.company.TuCarbures;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.Set;


@Profile({"TuCarbures"})

@Configuration
public class SwaggerConfig {

    private static final Set<String> JSON_MEDIA_TYPE = Collections.singleton(MediaType.APPLICATION_JSON_VALUE);

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .consumes(JSON_MEDIA_TYPE)
                .produces(JSON_MEDIA_TYPE)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo()).select()
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("TuCarbures REST APIs")
                .description("Gestion des stations APIs")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}
