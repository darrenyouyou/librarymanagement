package com.darrenyou.librarymanagement;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "isbn")
    private int isbn;

    @Column(name = "storeTime")
    private Timestamp storeTime;

    @Column(name = "status")
    private String status;

    @Column(name = "bookId")
    private int bookId;

    public Inventory() {
    }

    public Inventory(int id, int isbn, Timestamp storeTime, String status, int bookId) {
        this.id = id;
        this.isbn = isbn;
        this.storeTime = storeTime;
        this.status = status;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Timestamp getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(Timestamp storeTime) {
        this.storeTime = storeTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
