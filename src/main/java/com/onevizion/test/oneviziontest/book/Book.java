package com.onevizion.test.oneviziontest.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Book", schema = "public")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    public String title;
    public String author;
    public String description;
}
