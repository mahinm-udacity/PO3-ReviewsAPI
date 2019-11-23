create table comment(
    id int not null AUTO_INCREMENT,
    review_id int not null,
    comment_text varchar(1000),
    PRIMARY KEY (id),
    FOREIGN KEY (review_id)
        REFERENCES review(id)
);