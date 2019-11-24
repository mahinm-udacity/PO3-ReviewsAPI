package com.udacity.course3.reviews.domain.review;

import com.udacity.course3.reviews.domain.product.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAllByProduct(Product product);
}
