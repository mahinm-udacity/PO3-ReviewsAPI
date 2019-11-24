package com.udacity.course3.reviews.domain.comment;

import com.udacity.course3.reviews.domain.review.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByReview(Review review);
}
