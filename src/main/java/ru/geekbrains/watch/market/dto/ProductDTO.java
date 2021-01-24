package ru.geekbrains.watch.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Profile;
import ru.geekbrains.watch.market.model.Product;

@Data
@NoArgsConstructor
@Profile("product")
public class ProductDTO {
    private Long id;
    private String title;
    private String pathname;
    private String description;
    private int price;

    public ProductDTO(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.pathname = p.getPathname();
        this.description = p.getDescription();
        this.price = p.getPrice();
    }


}
