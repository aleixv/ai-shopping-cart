package com.example.ai_shopping_cart;

import com.example.ai_shopping_cart.domain.Cart;
import com.example.ai_shopping_cart.infrastructure.CartRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class AddItemToCartIntegrationTest {


    @Autowired
    private CartRepository cartRepository;

    @Test
    void contextLoads() {
        assertNotNull(cartRepository);
        Cart cart = new Cart(123L);
        cartRepository.save(cart);

    }
}