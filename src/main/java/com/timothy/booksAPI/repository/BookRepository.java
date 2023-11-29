package com.timothy.booksAPI.repository;

import com.timothy.booksAPI.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
