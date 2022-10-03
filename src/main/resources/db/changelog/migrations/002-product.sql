create table product(
    id int auto_increment,
    date varchar(255),
    customer_id int,
    product_name varchar(255),
    amount int CHECK (amount > 0),
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);