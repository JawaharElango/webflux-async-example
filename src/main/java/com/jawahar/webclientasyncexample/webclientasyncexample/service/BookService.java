package com.jawahar.webclientasyncexample.webclientasyncexample.service;


import com.jawahar.webclientasyncexample.webclientasyncexample.dao.BookDAO;
import com.jawahar.webclientasyncexample.webclientasyncexample.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBooks(){
        return bookDAO.getAllBooks();
    }

    public Flux<Book> getAllBooksUsingFlux(){
        return bookDAO.getAllBooksStream();
    }

}
