package com.jawahar.webclientasyncexample.webclientasyncexample.dao;

import com.jawahar.webclientasyncexample.webclientasyncexample.model.Book;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Repository
public class BookDAO {

    public static void createDelay(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks(){
        return IntStream.rangeClosed(1, 50)
                .peek(i -> System.out.println(" Processing book "+i))
                .peek(BookDAO::createDelay)
                .mapToObj(i -> new Book(i, "book " +i))
                .collect(Collectors.toList());
    }

    public Flux<Book> getAllBooksStream(){
        return Flux.range(1, 50)
                .doOnNext(i -> System.out.println(" Processing book in flux "+i))
                .delayElements(Duration.ofMillis(1000))
                .map(i -> new Book(i, "book "+i));
    }
}
