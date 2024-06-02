package com.onevizion.test.oneviziontest.book;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

//This old method, querying using JDBC template is created because it was asked in the task
@Repository
public class BookDao {

    private final String getBookByTitleDescQuery = "SELECT * FROM BOOK ORDER BY title DESC";

    private final JdbcTemplate jdbcTemplate;
//    private final JdbcClient jdbcClient;

    public BookDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksByTitleDesc() {
        return jdbcTemplate.query(getBookByTitleDescQuery,
                (result, rowNum) -> new Book(
                        result.getLong("id"),
                        result.getString("title"),
                        result.getString("author"),
                        result.getString("description")));
    }

}
