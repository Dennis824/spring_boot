package com.market.demo.repositories.specifications;


import com.market.demo.entities.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> priceGreaterOrEqualsThan(int minPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
    }

    public static Specification<Product> priceLesserOrEqualsThan(int maxPrice) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
    }

    public static Specification<Product> titleLike(String title) {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(
                criteriaBuilder.lower(root.get("title")), '%' + title.toLowerCase() + '%');
    }

    public static Specification<Product> priceIsEmpty() {
        return (Specification<Product>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isEmpty(root.get("price"));
    }

}


