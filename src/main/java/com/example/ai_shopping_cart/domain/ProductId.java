package com.example.ai_shopping_cart.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class ProductId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    public ProductId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}