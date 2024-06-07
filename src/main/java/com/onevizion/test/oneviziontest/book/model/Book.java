package com.onevizion.test.oneviziontest.book.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    public String title;
    public String author;
    public String description;

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", description=" + description + "]";
    }

    public static String BOOK_FIELD_ID = "id";
    public static String BOOK_FIELD_TITLE = "title";
    public static String BOOK_FIELD_AUTHOR = "author";
    public static String BOOK_FIELD_DESCRIPTION = "description";
}
