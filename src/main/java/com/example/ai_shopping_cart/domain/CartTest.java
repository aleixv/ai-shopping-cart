package com.example.ai_shopping_cart.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class CartTest {

    @Test
    void testAddItem() {
        Cart cart = new Cart();
        Item item = new Item("Test Item", 10.0);
        cart.addItem(item);
        List<Item> items = cart.getItems();
        assertEquals(1, items.size());
        assertEquals(item, items.get(0));
    }

    @Test
    void testRemoveItem() {
        Cart cart = new Cart();
        Item item = new Item("Test Item", 10.0);
        cart.addItem(item);
        cart.removeItem(item);
        List<Item> items = cart.getItems();
        assertEquals(0, items.size());
    }

    @Test
    void testGetTotalPrice() {
        Cart cart = new Cart();
        Item item1 = new Item("Item 1", 10.0);
        Item item2 = new Item("Item 2", 20.0);
        cart.addItem(item1);
        cart.addItem(item2);
        double totalPrice = cart.getTotalPrice();
        assertEquals(30.0, totalPrice);
    }
}
