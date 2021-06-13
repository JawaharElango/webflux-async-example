package com.jawahar.webclientasyncexample.webclientasyncexample.controller;

import com.jawahar.webclientasyncexample.webclientasyncexample.model.Book;
import com.jawahar.webclientasyncexample.webclientasyncexample.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> retriveAllBooks(){
        return bookService.getAllBooks();

    }

    @GetMapping(value = "/books/reactive", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> retriveAllBooksReactive(){
        return bookService.getAllBooksUsingFlux();
    }
}
