package com.ust.authors.controller;


import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;
import com.ust.authors.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    // POST /authors
    // GET  /authors/{name}
    // GET  /authors/{name}/books


    RestTemplate restTemplate;

    private List<Author> authorList = new ArrayList<Author>();

    public AuthorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping()
    public ResponseEntity<Author> addAuthor(Author author) {
        return ResponseEntity.ok(authorService.addAuthor(authorList,author));
    }
    @GetMapping("/{name}")
    public ResponseEntity<Author> findAuthorByName(@PathVariable String name) {
        var item = authorService.findAuthorByName(authorList,name);
        if(item == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(item);
    }

    @GetMapping("/{name}/books")
    public ResponseEntity<List<Book>> findBooksByAuthor(@PathVariable String name) {

        ResponseEntity<Book[]> response = restTemplate.getForEntity("http://localhost:8100/books/books/{author}",Book[].class,name);
        if (response.getStatusCode() == HttpStatus.OK) {
            return ResponseEntity.ok(Arrays.stream(response.getBody()).toList());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
