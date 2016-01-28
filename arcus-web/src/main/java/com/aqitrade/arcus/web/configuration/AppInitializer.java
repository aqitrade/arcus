package com.aqitrade.arcus.web.configuration;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import net.bull.javamelody.MonitoringFilter;
import net.bull.javamelody.SessionListener;

public class AppInitializer implements WebApplicationInitializer {

  private static final String JAVA_MELODY_FILTER = "javaMelody";
  private static final String CHARACTER_ENCODING_FILTER_ENCODING = "UTF-8";
  private static final String CHARACTER_ENCODING_FILTER_NAME = "characterEncoding";
  private static final String CHARACTER_ENCODING_FILTER_URL_PATTERN = "/*";

  private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
  private static final String DISPATCHER_SERVLET_MAPPING = "/";

  public void onStartup(ServletContext container) throws ServletException {

    // Create the 'root' Spring application context
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(AppConfig.class);

    // Add Listeners
    container.addListener(new SessionListener());
    container.addListener(new ContextLoaderListener(rootContext));

    EnumSet<DispatcherType> dispatcherTypes =
        EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
    configureCharacterEncodingFilter(container, dispatcherTypes);
    // Add Filters
    container.addFilter(JAVA_MELODY_FILTER, MonitoringFilter.class).addMappingForUrlPatterns(null,
        false, "/*");

    // Create the dispatcher servlet's Spring application context
    AnnotationConfigWebApplicationContext dispatcherServlet =
        new AnnotationConfigWebApplicationContext();
    dispatcherServlet.register(MvcConfig.class);

    // Register and map the dispatcher servlet
    ServletRegistration.Dynamic dispatcher =
        container.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(dispatcherServlet));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);
  }

  private void configureCharacterEncodingFilter(ServletContext servletContext,
      EnumSet<DispatcherType> dispatcherTypes) {
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding(CHARACTER_ENCODING_FILTER_ENCODING);
    characterEncodingFilter.setForceEncoding(true);
    FilterRegistration.Dynamic characterEncoding =
        servletContext.addFilter(CHARACTER_ENCODING_FILTER_NAME, characterEncodingFilter);
    characterEncoding.addMappingForUrlPatterns(dispatcherTypes, true,
        CHARACTER_ENCODING_FILTER_URL_PATTERN);
  }
}
