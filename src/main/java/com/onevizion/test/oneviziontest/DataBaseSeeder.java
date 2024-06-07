package com.onevizion.test.oneviziontest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataBaseSeeder {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertInitialData() {
        jdbcTemplate.execute("""
                INSERT INTO BOOK (id, title, author, description)
                VALUES (1, 'Crime and Punishment', 'F. Dostoevsky', null);
                """);
        jdbcTemplate.execute("""
                INSERT INTO BOOK (id, title, author, description)
                VALUES (2, 'Anna Karenina', 'L. Tolstoy', null);
                """);
        jdbcTemplate.execute("""
                INSERT INTO BOOK (id, title, author, description)
                VALUES (3, 'The Brothers Karamazov', 'F. Dostoevsky', null);
                """);
        jdbcTemplate.execute("""
                INSERT INTO BOOK (id, title, author, description)
                VALUES (4, 'War and Peace', 'L. Tolstoy', null);
                """);
        jdbcTemplate.execute("""
                INSERT INTO BOOK (id, title, author, description)
                VALUES (5, 'Dead Souls', 'N. Gogol', null);
                """);
    }
}
