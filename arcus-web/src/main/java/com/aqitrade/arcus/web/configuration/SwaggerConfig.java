package com.aqitrade.arcus.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;;

@EnableWebMvc
@EnableSwagger2
@ComponentScan("com.aqitrade.arcus.web.controller")
public class SwaggerConfig {

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
        .build().apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo =
        new ApiInfo("Arcus REST API", "Arcus API Catalog, which shows endpoint details", "1.0",
            "dev@aqitrade.com", "dev@aqitrade.com", "www.aqitrade.com", null);
    return apiInfo;
  }
}
