drop table if exists lim_orders;
drop table if exists lim_customers;

create table lim_customers (
    customerID int primary key auto_increment,
    customerName varchar(255) not null,
    customerAge int,
    customerAddress varchar(255)
);

create table lim_orders (
 orderID int primary key auto_increment,
 customerID int not null,
 orderDetail varchar(255),
 orderDate timestamp,
 orderAmount float,
 foreign key (customerID) references lim_customers(customerID)
);
