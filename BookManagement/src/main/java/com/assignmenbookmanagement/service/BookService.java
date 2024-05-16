package com.assignmenbookmanagement.service;

import com.assignmenbookmanagement.model.Book;
import com.assignmenbookmanagement.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    List<Book> books = new ArrayList<>();
    @Autowired
    BookRepo bookRepo;

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Optional<Book> getBookByIds(Long id) {
        return bookRepo.findById(id);
    }

    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepo.getBookById(id);
        existingBook.setDisc(book.getDisc());
        existingBook.setTitle(book.getTitle());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setPublishedDate(book.getPublishedDate());
        return bookRepo.save(existingBook);
    }

    public List<Book> getAll() {
        books = bookRepo.findAll();
        return books;
    }

    public void deleteBookById(long id) {
       Book bookdeleted =  bookRepo.getBookById(id);
       bookRepo.delete(bookdeleted);
    }
//    Creating a new book.
//    Retrieving a book by ID.
//    Retrieving all books.
//    Updating a book.
//    Deleting a book.


}
