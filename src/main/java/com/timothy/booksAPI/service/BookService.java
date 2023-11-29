package com.timothy.booksAPI.service;

import com.timothy.booksAPI.entity.Book;
import com.timothy.booksAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.StringTemplate.STR;

@Service
public class BookService {
    @Autowired
    private BookRepository repo;

    public Book saveBook(Book book){
        return repo.save(book);
    }

    public List<Book> saveBooks(List<Book> books) {
        return repo.saveAll(books);
    }

    public Book getBook(long isbn) {
        return repo.findById(isbn).orElseThrow();
    }

    public List<Book> getBooks() {
        return repo.findAll();
    }

    public String deleteBook(long isbn) {
        if(repo.existsById(isbn)){
            repo.deleteById(isbn);
            return STR."ISBN : \{isbn} deleted!";
        }else{
            return "ISBN not found!";
        }
    }

    public Book updateBook(long isbn, Book book) {
        Book updatedBook = repo.findById(isbn).orElseThrow();

        updatedBook.setIsbn(book.getIsbn());
        updatedBook.setName(book.getName());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setPublishDate(book.getPublishDate());

        return repo.save(updatedBook);
    }
}
