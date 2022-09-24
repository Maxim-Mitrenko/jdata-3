select * from ORDERS
join CUSTOMERS C on C.id = ORDERS.customer_id
where UPPER(name) = UPPER(:name);