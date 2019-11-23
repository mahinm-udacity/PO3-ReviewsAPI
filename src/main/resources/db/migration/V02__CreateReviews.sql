create table review (
    id int not null AUTO_INCREMENT,
    product_id int not null,
    review_text varchar(10000) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id)
        REFERENCES product(id)
);