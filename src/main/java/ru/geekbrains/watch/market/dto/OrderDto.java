package ru.geekbrains.watch.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.watch.market.model.Order;

@NoArgsConstructor
@Data
public class OrderDto {
    private Long id;
    private String username;
    private String address;
    private int totalPrice;
    private String creationDateTime;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.username = order.getOwner().getUsername();
        this.address = order.getAddress();
        this.totalPrice = order.getPrice();
        this.creationDateTime = order.getCreatedAt().toString();
    }
}
