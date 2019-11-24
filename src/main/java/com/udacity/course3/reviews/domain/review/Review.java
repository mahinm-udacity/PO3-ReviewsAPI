package com.udacity.course3.reviews.domain.review;

import com.udacity.course3.reviews.domain.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String reviewText;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    public Review(Product product, String reviewText){
        this.product = product;
        this.reviewText = reviewText;
    }

}
