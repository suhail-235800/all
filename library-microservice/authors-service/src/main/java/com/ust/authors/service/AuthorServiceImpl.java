package com.ust.authors.service;

import com.ust.authors.domain.Author;
import com.ust.authors.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Override
    public List<Book> findBooksByAuthor(String author) {
        return null;
    }

    @Override
    public Author findAuthorByName(List<Author> authorList, String name) {
        return authorList.stream()
                .filter(author -> author.getName().equals(name))
                .findFirst()
                .orElse(null);

    }

    @Override
    public Author addAuthor(List<Author> authorList,Author author) {
        authorList.add(author);
        return author;
    }


}
