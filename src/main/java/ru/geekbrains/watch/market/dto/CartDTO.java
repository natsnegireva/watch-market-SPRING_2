package ru.geekbrains.watch.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.watch.market.beans.Cart;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Data
public class CartDTO {
    private List<OrderItemDTO> items;
    private int totalPrice;

    public CartDTO(Cart cart) {
        this.totalPrice = cart.getTotalPrice();
        this.items = cart.getItems ().stream ().map (OrderItemDTO::new).collect (Collectors.toList ());
    }
}
