package com.udacity.course3.reviews.domain.comment;

import com.udacity.course3.reviews.domain.review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "review_id")
    private Review review;

    @NotNull
    @Size(min = 1, max = 1000)
    private String commentText;

    public Comment(Review review, String commentText) {
        this.review = review;
        this.commentText = commentText;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
