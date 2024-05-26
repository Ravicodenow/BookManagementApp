package com.assignmenbookmanagement.controller;

import com.assignmenbookmanagement.model.Book;
import com.assignmenbookmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This class is use for controller
 */
@RestController
@RequestMapping("/api")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
       Book createdBook =  bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> getBook(@PathVariable("id") Long id){
        Optional<Book> book =  bookService.getBookByIds(id);
        return  ResponseEntity.ok(book);
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBook(){
        List<Book> booklist = bookService.getAll();
        return ResponseEntity.ok(booklist);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updatebook(@PathVariable long id, @RequestBody Book book){
        Book updatedbook = bookService.updateBook(id,book);
        return ResponseEntity.ok(updatedbook);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void>deleteBook(@PathVariable long id){
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

}
