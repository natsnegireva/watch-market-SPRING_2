package ru.geekbrains.watch.market.validators;

import org.springframework.stereotype.Component;
import ru.geekbrains.watch.market.dto.ProductDto;
import ru.geekbrains.watch.market.exceptions.ValidationException;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductValidator {
    public void validate(ProductDto productDto) {
        List<String> errors = new ArrayList<>();
        if (productDto.getPrice() < 1) {
            errors.add("Цена продукта не может быть меньше 1");
        }
        if (productDto.getTitle().isBlank()) {
            errors.add("Продукт не может иметь пустое название");
        }
        if (!errors.isEmpty()) {
            throw new ValidationException (errors);
        }
    }
}
