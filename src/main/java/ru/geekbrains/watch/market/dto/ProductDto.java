package ru.geekbrains.watch.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.watch.market.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private int price;
    private String description;
    private String pathname;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.price = p.getPrice();
        this.description = p.getDescription ();
        this.pathname = p.getPathname ();
    }
}
