package com.aqitrade.arcus.web.configuration;

import javax.sql.DataSource;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.aqitrade.arcus.data.entity.UserEntity;
import com.aqitrade.arcus.data.repository.UserRepository;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.aqitrade.arcus")
// @EnableJpaRepositories("com.aqitrade.arcus.data")
public class JPAConfig {
  private final static Logger LOG = LoggerFactory.getLogger(JPAConfig.class);

  private @Value("${db.driver}") String driver;
  private @Value("${db.url}") String url;
  private @Value("${db.username}") String username;
  private @Value("${db.password}") String password;

  @Bean(name = "dataSource", destroyMethod = "close")
  public DataSource dataSource() {
    LOG.info("Initializing DB Connection Pooling for JDBC URL: {}", url);
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setJdbcUrl(url);
    dataSource.setUsername(username);
    dataSource.setPassword(password);
    dataSource.setMaximumPoolSize(2);
    return dataSource;
  }

  @Bean(name = "entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
    LocalContainerEntityManagerFactoryBean factoryBean =
        new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource());
    factoryBean.setPersistenceXmlLocation("classpath:META-INF/jpa-persistence.xml");
    factoryBean.setPersistenceUnitName("mysql");
    factoryBean.setPackagesToScan("com.aqitrade.arcus.data");
    factoryBean.setPackagesToScan(UserEntity.class.getPackage().getName());

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setShowSql(true);
    factoryBean.setJpaVendorAdapter(vendorAdapter);
    return factoryBean;
  }

  @Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
    return transactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }

  @Bean
  public DozerBeanMapper getMapper() {
    return new DozerBeanMapper();
  }

}
