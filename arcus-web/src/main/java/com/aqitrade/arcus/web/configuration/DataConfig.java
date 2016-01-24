package com.aqitrade.arcus.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.aqitrade.arcus.data")
@Import(JPAConfig.class)
public class DataConfig {

}
