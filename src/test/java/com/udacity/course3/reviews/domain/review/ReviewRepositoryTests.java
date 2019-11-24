package com.udacity.course3.reviews.domain.review;

import com.udacity.course3.reviews.domain.product.Product;
import com.udacity.course3.reviews.domain.product.ProductRepository;
import org.junit.BeforeClass;
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
public class ReviewRepositoryTests {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductRepository productRepository;

    private static Product testProduct;

    @BeforeClass
    public static void setup(){
        testProduct = new Product("test product");
    }

    @Test
    public void injectedComponentsAreNotNull(){
        assertNotNull(productRepository);
        assertNotNull(reviewRepository);
    }

    @Test
    public void testFindByReviewId() {
        String expectedReviewText = "my review";
        Review review = new Review(productRepository.save(testProduct), expectedReviewText);
        Review returnedReview = reviewRepository.save(review);
        Review retrievedReview = reviewRepository.findById(returnedReview.getId())
                .orElse(null);
        assertNotNull(retrievedReview);
        assertEquals(retrievedReview.getReviewText(), expectedReviewText);
    }

    @Test
    public void testFindAllByProduct(){
        int expectedNumberOfReviews = 3;
        for (int i = 0; i < expectedNumberOfReviews; i++){
            reviewRepository.save(new Review(productRepository.save(testProduct),String.valueOf(i)));
        }
        List<Review> reviews = reviewRepository.findAllByProduct(testProduct);
        assertEquals(expectedNumberOfReviews, reviews.size());
    }
}
