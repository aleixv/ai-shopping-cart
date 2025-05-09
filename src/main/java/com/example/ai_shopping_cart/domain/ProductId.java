package com.example.ai_shopping_cart.domain;

import java.util.UUID;

public class ProductId {
    private UUID id;

    public ProductId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}