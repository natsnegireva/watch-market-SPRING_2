package ru.geekbrains.watch.market.beans;

import lombok.Data;
import org.springframework.stereotype.Component;
import ru.geekbrains.watch.market.dto.ProductDto;
import ru.geekbrains.watch.market.exceptions_handling.ResourceNotFoundException;
import ru.geekbrains.watch.market.services.ProductService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
@Data
public class Cart {
    private ProductService productService;
    private List<ProductDto> order;
    private int price;
    private int quantity;

    @PostConstruct
    public void init() {
        order = new ArrayList<> ();
        this.quantity = 0;
        this.price = 0;
    }

    public void addProduct(Long productId) {
        order.add(productService.findProductById(productId).orElseThrow(() -> new ResourceNotFoundException ("Unable to find book with id: " + productId + " (add to cart)")));
        quantity++;
        price += price;
    }

    public void removeProduct(Long productId) {
        Iterator<ProductDto> it = order.iterator();
        while (it.hasNext()) {
            ProductDto p = it.next();
            if (p.getId ().equals (productId)) {
                price -= p.getPrice();
                quantity--;
                order.remove (p);
                it.remove();
                return;
            }
        }
    }

    public void clear() {
        order.clear();
        quantity = 0;
        price = 0;
    }
}
