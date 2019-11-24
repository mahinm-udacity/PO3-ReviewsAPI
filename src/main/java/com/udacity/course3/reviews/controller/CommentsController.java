package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.domain.comment.Comment;
import com.udacity.course3.reviews.domain.comment.CommentRepository;
import com.udacity.course3.reviews.domain.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CommentRepository commentRepository;

    /**
     * Creates a comment for a review.
     * <p>
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Integer reviewId,
                                                    @RequestBody Comment comment) {
        comment.setReview(ControllerUtilities.findEntity(reviewRepository, reviewId));
        return ResponseEntity.ok(commentRepository.save(comment));
    }

    /**
     * List comments for a review.
     * <p>
     * 1. Check for existence of review.
     * 2. If review not found, return NOT_FOUND.
     * 3. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        return ResponseEntity.ok(commentRepository.findAllByReview(
                ControllerUtilities.findEntity(reviewRepository, reviewId)));

    }
}