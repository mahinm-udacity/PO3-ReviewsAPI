package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.domain.product.Product;
import com.udacity.course3.reviews.domain.product.ProductRepository;
import com.udacity.course3.reviews.domain.review.Review;
import com.udacity.course3.reviews.domain.review.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ControllerUtilities {

    static protected Product findEntity(ProductRepository repository, Integer id){
        return repository.findById(Long.valueOf(id))
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Could not find entity with id " + id));

    }

    static protected Review findEntity(ReviewRepository repository, Integer id){
        return repository.findById(Long.valueOf(id))
                .orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Could not find entity with id " + id));
    }

}
