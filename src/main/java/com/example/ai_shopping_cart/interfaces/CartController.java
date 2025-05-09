package com.example.ai_shopping_cart.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ai_shopping_cart.application.AddItemToCartService;

import java.util.UUID;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final AddItemToCartService addItemToCartService;

    public CartController(AddItemToCartService addItemToCartService) {
        this.addItemToCartService = addItemToCartService;
    }

    @PostMapping("/items")
    public ResponseEntity<String> addItem(@RequestBody ItemDTO itemDTO) {
        addItemToCartService.addItemToCart(
                itemDTO.getCartId(),
                itemDTO.getProductId(),
                itemDTO.getName(),
                itemDTO.getPrice(),
                itemDTO.getQuantity()
        );
        return new ResponseEntity<>("Item added to cart", HttpStatus.OK);
    }
}