package ru.geekbrains.watch.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.watch.market.dto.ProductDto;
import ru.geekbrains.watch.market.exceptions_handling.ResourceNotFoundException;
import ru.geekbrains.watch.market.model.Product;
import ru.geekbrains.watch.market.repositories.specifications.ProductSpecifications;
import ru.geekbrains.watch.market.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping
    public Page<ProductDto> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page
    ) {
        Page<ProductDto> productDtoPage = null;
        if (page < 1) {
            page = 1;
        }
        try {
            productDtoPage = productService.findAll (ProductSpecifications.build (params), page, 2);

        } catch (NullPointerException n) {
            n.printStackTrace ();
        }
        return productDtoPage;
    }

    // http://localhost:8189/watch/api/v1/products
    @GetMapping("/{id}")
    public ProductDto findProductById(@PathVariable Long id) {
        return productService.findProductById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doens't exist"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveNewProduct(@RequestBody Product product) {
        product.setId(null);
        return productService.saveOrUpdate(product);
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.saveOrUpdate(product);
    }

    @DeleteMapping("/{id}")
    public void updateProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
