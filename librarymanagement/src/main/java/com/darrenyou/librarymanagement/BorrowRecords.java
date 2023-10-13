package com.darrenyou.librarymanagement;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "BorrowRecords")
public class BorrowRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userId")
    private int userId;
    @Column(name = "bookId")
    private int bookId;

    @Column(name = "borrowDate")
    private Timestamp borrowDate;

    @Column(name = "returnDate")
    private Timestamp returnDate;

    @Column(name = "inventoryId")
    private int inventoryId;

    public BorrowRecords() {
    }

    public BorrowRecords(int id, int userId, int bookId, Timestamp borrowDate, Timestamp returnDate, int inventoryId) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.inventoryId = inventoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Timestamp getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Timestamp borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }
}
