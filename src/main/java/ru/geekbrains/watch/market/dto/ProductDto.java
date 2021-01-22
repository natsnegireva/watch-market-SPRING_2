package ru.geekbrains.watch.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.watch.market.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private String pathname;
    private String description;
    private int price;

    public Long getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.pathname = p.getPathname();
        this.description = p.getDescription();
        this.price = p.getPrice();
    }


}
