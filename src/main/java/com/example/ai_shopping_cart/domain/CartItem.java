package com.example.ai_shopping_cart.domain;

public class CartItem {
    private ProductId productId;
    private String name;
    private double price;
    private int quantity;

    public CartItem(ProductId productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductId getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getSubtotal() {
        return price * quantity;
    }
}