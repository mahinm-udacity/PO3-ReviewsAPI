package com.udacity.course3.reviews.domain.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;


    @Test
    public void injectedComponentsAreNotNull() {
        assertNotNull(productRepository);
    }

    @Test
    public void testFindAllProducts() {
        int expectedNumberOfProducts = 5;
        for (int i = 0; i < expectedNumberOfProducts; i++) {
            productRepository.save(new Product("product" + i));
        }
        List<Product> products = productRepository.findAll();
        assertEquals(expectedNumberOfProducts, products.size());
    }
}


