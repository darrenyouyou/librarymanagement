DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Inventory;
DROP TABLE IF EXISTS Books;
DROP TABLE IF EXISTS BorrowRecords;

CREATE TABLE Users
(
    id int,
    phone varchar(255),
    password varchar(255),
    name varchar(255),
    registrationTime TIMESTAMP,
    lastLoginTime TIMESTAMP
);

CREATE TABLE Inventory
(
    id int,
    isbn int,
    storeTime TIMESTAMP,
    status varchar(255)
);

CREATE TABLE Books
(
    isbn int,
    name varchar(255),
    author varchar(255),
    introduction varchar(255)
);

CREATE TABLE BorrowRecords
(
    id int,
    userId int,
    bookId int,
    borrowDate TIMESTAMP,
    returnDate TIMESTAMP
);
