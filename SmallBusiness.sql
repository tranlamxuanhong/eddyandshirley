DROP DATABASE IF EXISTS smallBusiness;
CREATE DATABASE IF NOT EXISTS smallBusiness;
USE smallBusiness;

CREATE TABLE Customer (
	customerId INT PRIMARY KEY auto_increment,
    customerName VARCHAR(30) not null,
    phoneNumber INT not null,
    emailAddress VARCHAR(30)
    
);

CREATE TABLE Transaction (
	transactionId int primary key auto_increment,
    customerId int,
    totalBillPerTransaction int not null,
    transactionDate DATE not null,
    status varchar(20) not null,
    FOREIGN KEY (customerId) REFERENCES Customer(customerId)
);


CREATE TABLE Item (
	itemId int Primary Key auto_increment,
    itemName varchar(30) not null,
    price int not null,
    createdDate date
);

CREATE TABLE transactionItem (
	transactionItemId int Primary Key auto_increment,
    itemId int,
    transactionId int,
    itemPrice int,
    itemQuantity int,
    totalBillPerItem int,
    FOREIGN KEY (itemId)  REFERENCES Item(itemId),
    FOREIGN KEY (transactionId) REFERENCES Transaction(transactionId)
);

CREATE TABLE receiving (
	receivingId int Primary Key auto_increment,
    receivingDate DATE not null,
    itemId int,
    quantity int not null,
    FOREIGN KEY(itemId) REFERENCES Item(itemId)
);

CREATE TABLE File (
	fileId int primary key auto_increment,
    `name` varchar(30) not null,
    `path` varchar(50) not null
    
);









