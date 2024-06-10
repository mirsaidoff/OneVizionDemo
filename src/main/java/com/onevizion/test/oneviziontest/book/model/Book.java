package com.onevizion.test.oneviziontest.book.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String title;
    public String author;
    public String description;

    public Book(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description + "]";
    }

    public static String BOOK_FIELD_ID = "id";
    public static String BOOK_FIELD_TITLE = "title";
    public static String BOOK_FIELD_AUTHOR = "author";
    public static String BOOK_FIELD_DESCRIPTION = "description";
}
