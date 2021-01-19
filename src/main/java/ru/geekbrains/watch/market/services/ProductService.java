package ru.geekbrains.watch.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.watch.market.dto.ProductDto;
import ru.geekbrains.watch.market.model.Product;
import ru.geekbrains.watch.market.repositories.ProductRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Optional<ProductDto> findProductById(Long id) {
        return productRepository.findById(id).map(ProductDto::new);
    }

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        return productRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(ProductDto::new);
    }

    public Product saveOrUpdate(Product p) {
        return productRepository.save(p);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
