package com.example.ai_shopping_cart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.ai_shopping_cart.infrastructure")
public class AiShoppingCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiShoppingCartApplication.class, args);
    }

}