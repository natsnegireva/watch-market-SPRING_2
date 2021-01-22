package ru.geekbrains.watch.market.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.watch.market.beans.Cart;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {
    private final Cart cart;

    @Autowired
    public CartController(Cart cart) {
        this.cart = cart;
    }

    @GetMapping("/add/{productId}")
    public void addProduct(@PathVariable(name = "book_id") Long productId) {
        cart.addProduct (productId);
    }

    @GetMapping("/remove/{productId}")
    public void removeProduct(@PathVariable(name = "book_id") Long productId) {
        cart.removeProduct (productId);
    }

    @GetMapping("/clear/")
    public void clear() {
        cart.clear ();
    }
}
