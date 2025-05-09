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
    public void testAddItemToCart() {
        // Given
        UUID cartId = UUID.randomUUID();
        UUID productId = UUID.randomUUID();
        String itemName = "Test Item";
        double itemPrice = 10.0;
        int quantity = 2;

        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setCartId(cartId);
        itemDTO.setProductId(productId);
        itemDTO.setName(itemName);
        itemDTO.setPrice(itemPrice);
        itemDTO.setQuantity(quantity);

        // When
        ResponseEntity<String> response = restTemplate.postForEntity("/cart/items", itemDTO, String.class);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Item added to cart", response.getBody());

        Cart cart = cartRepository.findById(cartId).orElse(null);
        assertNotNull(cart);
        List<CartItem> items = cart.getItems();
        assertEquals(1, items.size());
        CartItem cartItem = items.get(0);
        assertEquals(productId, cartItem.getProductId().getId());
        assertEquals(itemName, cartItem.getName());
        assertEquals(itemPrice, cartItem.getPrice());
        assertEquals(quantity, cartItem.getQuantity());
    }
}