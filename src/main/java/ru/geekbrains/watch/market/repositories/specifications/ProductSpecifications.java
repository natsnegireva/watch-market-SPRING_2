package ru.geekbrains.watch.market.repositories.specifications;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import ru.geekbrains.watch.market.model.Product;

import java.util.Objects;

public class ProductSpecifications {
    private static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo (root.get ("price"), minPrice);
    }

    private static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo (root.get ("price"), maxPrice);
    }

    private static Specification<Product> titleLike(String titlePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like (root.get ("title"), String.format ("%%%s%%", titlePart));
    }

    private static Specification<Product> descriptionLike(String descriptionPart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like (root.get ("description"), String.format ("%%%s%%", descriptionPart));
    }

    private static Specification<Product> pathnameLike(String pathnamePart) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like (root.get ("pathname"), String.format ("%%%s%%", pathnamePart));
    }


    // заменила isBlank
    public static Specification<Product> build(MultiValueMap<String, String> params) {
        Specification<Product> spec = Specification.where (null);
        if (params.containsKey ("min_price") && !Objects.requireNonNull (params.getFirst ("min_price")).isEmpty ()) {
            spec = spec.and (ProductSpecifications.priceGreaterOrEqualsThan (Integer.parseInt (Objects.requireNonNull (params.getFirst ("min_price")))));
        }
        if (params.containsKey ("max_price") && !Objects.requireNonNull (params.getFirst ("max_price")).isEmpty ()) {
            spec = spec.and (ProductSpecifications.priceLesserOrEqualsThan (Integer.parseInt (Objects.requireNonNull (params.getFirst ("max_price")))));
        }
        if (params.containsKey ("title") && !Objects.requireNonNull (params.getFirst ("title")).isEmpty ()) {
            spec = spec.and (ProductSpecifications.titleLike (params.getFirst ("title")));
        }
        if (params.containsKey ("description") && !Objects.requireNonNull (params.getFirst ("description")).isEmpty ()) {
            spec = spec.and (ProductSpecifications.descriptionLike (params.getFirst ("description")));
        }
        if (params.containsKey ("pathname") && !Objects.requireNonNull (params.getFirst ("pathname")).isEmpty ()) {
            spec = spec.and (ProductSpecifications.pathnameLike (params.getFirst ("pathname")));
        }
        return spec;
    }
}
