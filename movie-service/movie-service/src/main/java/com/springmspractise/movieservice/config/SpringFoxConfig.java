package com.springmspractise.movieservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.nio.file.Path;
import java.util.Collections;

/**
 * Created by rahulg1 on 2/7/2021.
 */

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springmspractise.movieservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Movie-Service",
                "Api to fetch movies",
                "1.0.0",
                "Terms of Service Url",
                new Contact("rahul", "https://github.com/raulgupto", "rahulgupta.becse14@gmail.com"),
                "License",
                "License url",
                Collections.emptyList()
        );
    }
}
