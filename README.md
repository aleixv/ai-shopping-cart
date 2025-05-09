# ai-shopping-cart

This project is a simple Shopping Cart microservice built with Spring Boot and following Domain Driven Design (DDD) principles.

## Purpose

The purpose of this project is to demonstrate a basic implementation of a shopping cart service with essential functionalities like adding items, removing items, and calculating the total price.

## Contents

## How to Run Locally

1.  Clone the repository to your local machine.
2.  Navigate to the project directory.
3.  Run the application using the command: `./gradlew bootRun`

## How to Run with Docker

1.  Clone the repository to your local machine.
2.  Navigate to the project directory.
3.  Run the application and database using Docker Compose: `docker-compose up`

The project structure is organized as follows:

-   `src/main/java/com/example/ai_shopping_cart/domain`: Contains the domain entities, value objects, and domain services.
-   `src/main/java/com/example/ai_shopping_cart/application`: Contains the application services that orchestrate the domain logic.
-   `src/main/java/com/example/ai_shopping_cart/infrastructure`: Contains the infrastructure implementations, such as repositories and external service integrations.
-   `src/main/java/com/example/ai_shopping_cart/interfaces`: Contains the API endpoints and data transfer objects (DTOs).
-   `src/main/resources`: Contains the application configuration files.

## Example: Add Item to Cart

This example demonstrates how to add an item to the shopping cart using an API endpoint.

1.  Create a `CartController` in the `interfaces` layer:

    ```java
    // src/main/java/com/example/ai_shopping_cart/interfaces/CartController.java
    @RestController
    @RequestMapping("/cart")
    public class CartController {

        @PostMapping("/items")
        public ResponseEntity<String> addItem(@RequestBody ItemDTO itemDTO) {
            // Implementation to add item to cart
            return new ResponseEntity<>("Item added to cart", HttpStatus.OK);
        }
    }
    ```

2.  Create an `ItemDTO` in the `interfaces` layer:

    ```java
    // src/main/java/com/example/ai_shopping_cart/interfaces/ItemDTO.java
    public class ItemDTO {
        private String itemId;
        private int quantity;

        // Getters and setters
    }
    ```