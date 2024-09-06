package com.example.SpringBootRestfulBookMgmt.service;

import com.example.SpringBootRestfulBookMgmt.entity.Book;
import com.example.SpringBootRestfulBookMgmt.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final com.example.SpringBootRestfulBookMgmt.repository.BookRepository bookRepository;

    public BookService(com.example.SpringBootRestfulBookMgmt.repository.BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<com.example.SpringBootRestfulBookMgmt.entity.Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<com.example.SpringBootRestfulBookMgmt.entity.Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    public com.example.SpringBootRestfulBookMgmt.entity.Book addBook(com.example.SpringBootRestfulBookMgmt.entity.Book book) {
        return bookRepository.save(book);
    }

    public com.example.SpringBootRestfulBookMgmt.entity.Book updateBook(Long id, com.example.SpringBootRestfulBookMgmt.entity.Book newBookDetails) {
        return bookRepository.findById(id).map(book -> {
            book.setTitle(newBookDetails.getTitle());
            book.setAuthor(newBookDetails.getAuthor());
            book.setPublicationYear(newBookDetails.getPublicationYear());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Book not found"));
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

