package com.udacity.course3.reviews.domain.product;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
public class Product {
    @NotNull
    @Size(min = 1, max = 100)
    String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Product(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
