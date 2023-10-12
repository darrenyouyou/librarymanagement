package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book insertBook(int isbn, String name, String author, String introduction) {
        Book book = new Book();
        book.setIsbn(isbn);
        book.setName(name);
        book.setAuthor(author);
        book.setIntroduction(introduction);
        return bookRepository.saveAndFlush(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
