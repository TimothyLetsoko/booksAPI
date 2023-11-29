package com.timothy.booksAPI.controller;

import com.timothy.booksAPI.entity.Book;
import com.timothy.booksAPI.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService service;

    @PostMapping("/book")
    public Book saveBook(@RequestBody Book book){
        return service.saveBook(book);
    }
    @PostMapping("/books")
    public List<Book> saveBooks(@RequestBody List<Book> books){
        return service.saveBooks(books);
    }
    @GetMapping("/books/{isbn}")
    public Book getBook(@PathVariable long isbn){
        return service.getBook(isbn);
    }
    @GetMapping("/books")
    public List<Book> getBooks(){
        return service.getBooks();
    }
    @DeleteMapping("/books/{isbn}")
    public String deleteBook(@PathVariable long isbn){
        return service.deleteBook(isbn);
    }
    @PutMapping("/books/{isbn}")
    public Book updateBook(@PathVariable long isbn, @RequestBody Book book){
        return service.updateBook(isbn, book);
    }
}
