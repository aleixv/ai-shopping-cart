package com.example.ai_shopping_cart.application;

import com.example.ai_shopping_cart.domain.Cart;
import com.example.ai_shopping_cart.domain.CartItem;
import com.example.ai_shopping_cart.domain.ProductId;
import com.example.ai_shopping_cart.infrastructure.CartRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AddItemToCartService {

    private final CartRepository cartRepository;

    public AddItemToCartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addItemToCart(Long cartId, UUID productId, String name, double price, int quantity) {
        Cart cart = cartRepository.findById(cartId).orElseGet(() -> {
            Cart newCart = new Cart(cartId);
            return cartRepository.save(newCart);
        });

        CartItem cartItem = new CartItem(productId, name, price, quantity, cart);
        cart.addItem(cartItem);

        cartRepository.save(cart);
    }
}