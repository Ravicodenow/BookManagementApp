package com.assignmenbookmanagement.repository;

import com.assignmenbookmanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<Book,Long> {

    Book getBookById(Long id);
}
