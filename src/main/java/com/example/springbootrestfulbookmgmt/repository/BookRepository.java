package com.example.springbootrestfulbookmgmt.repository;

import com.example.springbootrestfulbookmgmt.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
