CREATE TABLE CUSTOMERS(
    id int auto_increment,
    name varchar(255),
    surname varchar(255),
    age int CHECK (age > 0),
    phone_number varchar(255),
    PRIMARY KEY (id));