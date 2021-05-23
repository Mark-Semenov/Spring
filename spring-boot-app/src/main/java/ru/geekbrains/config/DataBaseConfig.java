package ru.geekbrains.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.entities.Product;
import ru.geekbrains.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@Configuration
@ComponentScan("ru.geekbrains")
public class DataBaseConfig {

    @Bean
    public EntityManager entityManager (){
        EntityManagerFactory factory = new org.hibernate.cfg.Configuration()
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        return factory.createEntityManager();
    }


}
