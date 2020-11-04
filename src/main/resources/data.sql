insert into lim_customers (customerID, customerName, customerAge, customerAddress) values (101, 'bob', 30, 'malaysia');
insert into lim_customers (customerID, customerName, customerAge, customerAddress) values (100, 'alice', 20, 'singapore');

insert into lim_orders(orderID, customerID, orderDetail, orderDate, orderAmount) values (200, 100, 'phones', current_timestamp, 100.0);
insert into lim_orders(orderID, customerID, orderDetail, orderDate, orderAmount) values (201, 100, 'books', current_timestamp, 200.0);
insert into lim_orders(orderID, customerID, orderDetail, orderDate, orderAmount) values (202, 101, 'cars', current_timestamp, 5000.0);
insert into lim_orders(orderID, customerID, orderDetail, orderDate, orderAmount) values (203, 101, 'books', current_timestamp, 150.0);
insert into lim_orders(orderID, customerID, orderDetail, orderDate, orderAmount) values (204, 101, 'tvs', current_timestamp, 800.0);
