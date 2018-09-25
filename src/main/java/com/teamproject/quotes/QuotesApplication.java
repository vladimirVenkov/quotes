package com.teamproject.quotes;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuotesApplication.class, args);
    }

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }
}
