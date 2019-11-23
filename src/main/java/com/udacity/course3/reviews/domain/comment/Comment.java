package com.udacity.course3.reviews.domain.comment;

import com.udacity.course3.reviews.domain.review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentText;

    @ManyToOne(fetch = FetchType.LAZY)
    private Review review;

}
