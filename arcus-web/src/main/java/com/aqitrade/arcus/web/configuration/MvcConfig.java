package com.aqitrade.arcus.web.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.aqitrade.arcus.web.handler.AuthentictionHandlerInterceptor;
import com.aqitrade.arcus.web.viewresolver.JsonViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.aqitrade.arcus")
@Import({SwaggerConfig.class, WebConfig.class})
public class MvcConfig extends WebMvcConfigurerAdapter {

  @Autowired
  private AuthentictionHandlerInterceptor authentictionHandlerInterceptor;

  /*
   * Configure ContentNegotiationManager
   */
  @Override
  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer.ignoreAcceptHeader(false).defaultContentType(MediaType.APPLICATION_JSON);
  }

  /*
   * Configure ContentNegotiatingViewResolver
   */
  @Bean
  public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
    final ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    resolver.setContentNegotiationManager(manager);

    // Define all possible view resolvers
    final List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

    resolvers.add(jsonViewResolver());
    resolvers.add(jspViewResolver());

    resolver.setViewResolvers(resolvers);
    return resolver;
  }

  /*
   * Configure View resolver to provide JSON output using JACKSON library to convert object in JSON
   * format.
   */
  @Bean
  public ViewResolver jsonViewResolver() {
    return new JsonViewResolver();
  }

  /*
   * Configure View resolver to provide HTML output This is the default format in absence of any
   * type suffix.
   */
  @Bean
  public ViewResolver jspViewResolver() {
    final InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class);
    viewResolver.setPrefix("/WEB-INF/views/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Bean(name = "messageSource")
  public ReloadableResourceBundleMessageSource getMessageSource() {
    final ReloadableResourceBundleMessageSource resource =
        new ReloadableResourceBundleMessageSource();
    resource.setBasename("classpath:messages/messages");
    resource.setDefaultEncoding("UTF-8");
    return resource;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // registry.addInterceptor(authentictionHandlerInterceptor).addPathPatterns("/**")
    // .excludePathPatterns("/login/**").excludePathPatterns("/logout/**").excludePathPatterns("**/*.css")
    // .excludePathPatterns("**/*.html").excludePathPatterns("**/*.png");
  }

}
