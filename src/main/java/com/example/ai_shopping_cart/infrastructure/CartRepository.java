package com.example.ai_shopping_cart.infrastructure;

import com.example.ai_shopping_cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

}