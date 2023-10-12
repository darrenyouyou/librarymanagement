package com.darrenyou.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/insert_book")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Book> insertBook(@RequestParam int isbn, @RequestParam String name, @RequestParam String author, @RequestParam String introduction) {
        Book newBook = bookService.insertBook(isbn, name, author, introduction);
        return ResponseEntity.ok(newBook);
    }

    @GetMapping("/books")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }
}
