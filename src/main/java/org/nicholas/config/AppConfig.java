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

    @Value("${hibernate.connection.driver_class}")
    String driverClass;
    @Value("${hibernate.connection.url}")
    String url;
    @Value("${hibernate.connection.user}")
    String user;
    @Value("${hibernate.connection.password}")
    String password;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
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
