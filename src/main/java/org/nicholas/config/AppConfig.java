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



//    Creating repositories beans
    @Bean
    public DefaultRepository<Author, Integer> authorRepository(){
        RepositoryImpl<Author, Integer> repository = new RepositoryImpl<>(factory().getObject(), Author.class);
        return repository;
    }
    @Bean
    public DefaultRepository<BookCategory, Integer> bookCategoryRepository(){
        RepositoryImpl<BookCategory, Integer> repository = new RepositoryImpl<>(factory().getObject(), BookCategory.class);
        return repository;
    }
    @Bean
    public DefaultRepository<Book, Integer> bookRepository(){
        RepositoryImpl<Book, Integer> repository = new RepositoryImpl<>(factory().getObject(), Book.class);
        return repository;
    }
    @Bean
    public DefaultRepository<RefContactType, Integer> refContactTypeRepository(){
        RepositoryImpl<RefContactType, Integer> repository = new RepositoryImpl<>(factory().getObject(), RefContactType.class);
        return repository;
    }
    @Bean
    public DefaultRepository<Contact, Integer> contactRepository(){
        RepositoryImpl<Contact, Integer> repository = new RepositoryImpl<>(factory().getObject(), Contact.class);
        return repository;
    }
    @Bean
    public DefaultRepository<Customer, Integer> customerRepository(){
        RepositoryImpl<Customer, Integer> repository = new RepositoryImpl<>(factory().getObject(), Customer.class);
        return repository;
    }
    @Bean
    public DefaultRepository<Order, Integer> orderRepository(){
        RepositoryImpl<Order, Integer> repository = new RepositoryImpl<>(factory().getObject(), Order.class);
        return repository;
    }
    @Bean
    public DefaultRepository<OrderItem, Integer> orderItemRepository(){
        RepositoryImpl<OrderItem, Integer> repository = new RepositoryImpl<>(factory().getObject(), OrderItem.class);
        return repository;
    }
}
