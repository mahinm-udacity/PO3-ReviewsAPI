package com.udacity.course3.reviews.domain.comment;

import com.udacity.course3.reviews.domain.product.Product;
import com.udacity.course3.reviews.domain.product.ProductRepository;
import com.udacity.course3.reviews.domain.review.Review;
import com.udacity.course3.reviews.domain.review.ReviewRepository;
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
public class CommentsRepositoryTests {
    private static Product testProduct;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductRepository productRepository;

    @BeforeClass
    public static void setup() {
        testProduct = new Product("test product");
    }

    @Test
    public void injectedComponentsAreNotNull() {
        assertNotNull(commentRepository);
    }

    @Test
    public void testFindByCommentId() {
        String expectedCommentText = "my comment";
        Review review = new Review(productRepository.save(testProduct), "my review");
        reviewRepository.save(review);
        Comment savedComment = commentRepository.save(new Comment(review, expectedCommentText));
        Comment retrievedComment = commentRepository.findById(savedComment.getId())
                .orElse(null);
        assertNotNull(retrievedComment);
        assertEquals(retrievedComment.getCommentText(), expectedCommentText);
    }

    @Test
    public void testFindAllCommentsByReview() {
        Review review = new Review(productRepository.save(testProduct), "my review");
        reviewRepository.save(review);
        int expectedNumberOfComments = 4;
        for (int i = 0; i < expectedNumberOfComments; i++) {
            commentRepository.save(new Comment(review, String.valueOf(i)));
        }
        List<Comment> comments = commentRepository.findAllByReview(review);
        assertEquals(expectedNumberOfComments, comments.size());
    }

}
