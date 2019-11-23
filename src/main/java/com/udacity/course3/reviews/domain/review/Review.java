package com.udacity.course3.reviews.domain.review;

import com.udacity.course3.reviews.domain.comment.Comment;
import com.udacity.course3.reviews.domain.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reviewText;

    public Review(String reviewText){
        this.reviewText = reviewText;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;


    @OneToMany(
            mappedBy = "review",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment){
        comments.add(comment);
        comment.setReview(this);
    }

    public void removeComment(Comment comment){
        comments.remove(comment);
        comment.setReview(this);
    }



}
