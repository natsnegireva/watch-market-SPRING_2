package ru.geekbrains.watch.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.watch.market.model.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private String imgPathname;
    private String description;
    private int price;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.imgPathname = p.getImgPathname();
        this.description = p.getDescription();
        this.price = p.getPrice();
    }

}
