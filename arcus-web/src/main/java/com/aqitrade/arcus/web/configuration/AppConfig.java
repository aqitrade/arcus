package com.aqitrade.arcus.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@ComponentScan(basePackages = "com.aqitrade.arcus.core")
@Import({ MvcConfig.class, ServiceConfig.class, DataConfig.class,
		JPAConfig.class, SwaggerConfig.class })
public class AppConfig {

	static @Bean public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer p = new PropertySourcesPlaceholderConfigurer();
		Resource[] resourceLocations = new Resource[] { new ClassPathResource(
				"arcus.properties") };
		p.setLocations(resourceLocations);
		return p;
	}

	@Bean
	public ObjectMapper mapper() {
		return new com.fasterxml.jackson.databind.ObjectMapper();
	}
}
