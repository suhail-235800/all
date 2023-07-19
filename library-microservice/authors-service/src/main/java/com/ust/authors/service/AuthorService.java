package com.ust.authors.service;

import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorService {

    List<Book> findBooksByAuthor(String author);

    Author findAuthorByName(List<Author> authorList, String name);


    Author addAuthor(List<Author> authorList,Author author);
}
