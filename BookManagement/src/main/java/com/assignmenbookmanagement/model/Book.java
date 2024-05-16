package com.assignmenbookmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
    @Id
    private Long id;
    private String title;
    private String disc;
    private String isbn;
    private String author;
    private LocalDate publishedDate;

}
