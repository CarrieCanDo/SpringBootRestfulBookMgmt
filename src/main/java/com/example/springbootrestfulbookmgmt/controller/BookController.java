package com.example.springbootrestfulbookmgmt.controller;

import com.example.springbootrestfulbookmgmt.entity.Book;
import com.example.springbootrestfulbookmgmt.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    // Constructor injection for BookService
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBookDetails) {
        return bookService.updateBook(id, newBookDetails);
    }

   @DeleteMapping("/{id}")
   public void deleteBook(@PathVariable Long id) {
   bookService.deleteBook(id);
   }
}