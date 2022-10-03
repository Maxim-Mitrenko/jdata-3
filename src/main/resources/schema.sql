CREATE TABLE customer(
    id int auto_increment,
    name varchar(255),
    surname varchar(255),
    age int CHECK (age > 0),
    phone_number varchar(255),
    PRIMARY KEY (id));

INSERT INTO customer(name, surname, age, phone_number) VALUES('Иван', 'Иванов', 21, '+799999999999');
INSERT INTO customer(name, surname, age, phone_number) VALUES('Алексей', 'Иванов', 27, '+79612345511');
INSERT INTO customer(name, surname, age, phone_number) VALUES('Алексей', 'Сергеев', 33, '+79612342396');

create table product(
    id int auto_increment,
    date varchar(255),
    customer_id int,
    product_name varchar(255),
    amount int check (amount > 0),
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

INSERT INTO product(customer_id, date, product_name, amount) VALUES(1, '01.01.2022', 'Сайт', 50000);
INSERT INTO product(customer_id, date, product_name, amount) VALUES(2, '01.02.2022', 'Чат-бот', 20000);
INSERT INTO product(customer_id, date, product_name, amount) VALUES(3, '01.03.2022', 'Приложение', 200000);