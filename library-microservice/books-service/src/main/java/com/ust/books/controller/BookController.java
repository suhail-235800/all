package com.ust.books.controller;

import com.ust.books.domain.Book;
import com.ust.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    List<Book> booksList = new ArrayList<Book>();

    @PostMapping()
    public ResponseEntity<Book> addBook(Book book) {
        return ResponseEntity.ok(bookService.addBook(booksList,book));
    }
    @GetMapping("/{title}")
    public ResponseEntity<Book> findBookByTitle(@PathVariable String title) {
        var item = bookService.findBookByTitle(booksList,title);
        if(item == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(item);
    }
    @GetMapping("/books/{author}")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable String author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : booksList) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        if (!booksByAuthor.isEmpty()) {
            return new ResponseEntity<>(booksByAuthor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
