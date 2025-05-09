package com.example.ai_shopping_cart;

import com.example.ai_shopping_cart.domain.Cart;
import com.example.ai_shopping_cart.infrastructure.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AddItemToCartIntegrationTest {

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.3-alpine");

    @DynamicPropertySource
    static void postgreSQLProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
    }

    @Autowired
    private CartRepository cartRepository;

    @Test
    void contextLoads() {
        assertNotNull(cartRepository);
        Cart cart = new Cart(123L);
        cartRepository.save(cart);

    }
}