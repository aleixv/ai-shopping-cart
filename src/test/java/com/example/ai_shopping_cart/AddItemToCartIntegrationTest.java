package com.example.ai_shopping_cart;

import com.example.ai_shopping_cart.domain.Cart;
import com.example.ai_shopping_cart.domain.CartItem;
import com.example.ai_shopping_cart.infrastructure.CartRepository;
import com.example.ai_shopping_cart.interfaces.ItemDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddItemToCartIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CartRepository cartRepository;

     @Test
    public void testAddItemToCart() {}