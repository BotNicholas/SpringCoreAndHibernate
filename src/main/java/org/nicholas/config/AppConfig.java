package org.nicholas.config;

import org.hibernate.SessionFactory;
import org.nicholas.model.*;
import org.nicholas.repository.DefaultRepository;
import org.nicholas.repository.RepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("org.nicholas")
@PropertySource("classpath:connection.properties")
//Этой аннотацией ты говоришь Spring-у самому управлять транзакциями. Но для того, чтобы он мог это делать (создавать прокси), ему нужен менеджер, который мы создаем тут
@EnableTransactionManagement(proxyTargetClass = false)
public class AppConfig {

    private Environment environment;

    @Autowired
    public AppConfig(Environment environment){
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("hibernate.connection.driver_class"));
        dataSource.setUrl(environment.getProperty("hibernate.connection.url"));
        dataSource.setUsername(environment.getProperty("hibernate.connection.user"));
        dataSource.setPassword(environment.getProperty("hibernate.connection.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean factory(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties hibernateProperties = new Properties();
        try {
            hibernateProperties.load(new FileReader("src/main/resources/hibernate.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        factoryBean.setDataSource(dataSource());
        factoryBean.setHibernateProperties(hibernateProperties);
        factoryBean.setPackagesToScan("org.nicholas.model");

        return factoryBean;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(factory().getObject());
        return transactionManager;
    }
}
