package com.example.ai_shopping_cart.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private CartId cartId;
    private List<CartItem> items;

    public Cart(CartId cartId) {
        this.cartId = cartId;
        this.items = new ArrayList<>();
    }

    public CartId getCartId() {
        return cartId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void addItem(CartItem item) {
        this.items.add(item);
    }

    public void removeItem(CartItem item) {
        this.items.remove(item);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    public static class CartId {
        private UUID id;

        public CartId(UUID id) {
            this.id = id;
        }

        public UUID getId() {
            return id;
        }
    }
}