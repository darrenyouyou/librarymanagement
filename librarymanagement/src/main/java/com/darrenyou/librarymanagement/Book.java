package com.darrenyou.librarymanagement;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int isbn;

    @Column(name = "author")
    private String author;

    @Column(name = "name")
    private String name;

    @Column(name = "introduction")
    private String introduction;

    public Book() {
    }

    public Book(int isbn, String author, String name, String introduction) {
        this.isbn = isbn;
        this.author = author;
        this.name = name;
        this.introduction = introduction;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
