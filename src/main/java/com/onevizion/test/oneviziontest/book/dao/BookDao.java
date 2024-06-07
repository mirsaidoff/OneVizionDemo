package com.onevizion.test.oneviziontest.book.dao;

import com.onevizion.test.oneviziontest.book.model.AuthorBookTitleSymbolCount;
import com.onevizion.test.oneviziontest.book.model.AuthorBooks;
import com.onevizion.test.oneviziontest.book.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

import static com.onevizion.test.oneviziontest.book.model.Book.*;

@Repository
public class BookDao {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParamJdbcTemplate;

    public BookDao(final JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParamJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParamJdbcTemplate = namedParamJdbcTemplate;
    }

    public List<Book> getBooksByTitleDesc() {
        String getBookByTitleDescQuery = "SELECT * FROM BOOK ORDER BY title DESC";
        return jdbcTemplate.query(getBookByTitleDescQuery,
                (result, rowNum) -> new Book(
                        result.getLong(BOOK_FIELD_ID),
                        result.getString(BOOK_FIELD_TITLE),
                        result.getString(BOOK_FIELD_AUTHOR),
                        result.getString(BOOK_FIELD_DESCRIPTION)));
    }

    public List<AuthorBooks> getAuthorBooks() {
        String getAuthorBooksQuery = "SELECT a.author, GROUP_CONCAT(a.title) AS book_list FROM Book a GROUP BY a.author";
        return jdbcTemplate.query(getAuthorBooksQuery,
                (result, rowNum) -> {
                    String books = result.getString("book_list");
                    List<String> bookList = Arrays.stream(books.split(",")).toList();
                    return new AuthorBooks(
                            result.getString(BOOK_FIELD_AUTHOR),
                            bookList
                    );
                });
    }

    public void save(final Book book) {
        String insertBookQuery = "INSERT INTO BOOK (title, author, description) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertBookQuery, book.getTitle(), book.getAuthor(), book.getDescription());
    }


    public List<AuthorBookTitleSymbolCount> getAuthorBookCountBySymbolOccurrence(String s) {
        String getAuthorBookCountBySymbolOccurrenceQuery = """
                SELECT b.author, SUM(LENGTH(b.title) - LENGTH(REPLACE(b.title, :symbol, ''))) AS symbol_count
                FROM book b
                GROUP BY b.author
                HAVING symbol_count > 0
                ORDER BY symbol_count DESC
                LIMIT 10
                """;
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("symbol", s);
        return namedParamJdbcTemplate.query(getAuthorBookCountBySymbolOccurrenceQuery, params, (result, rowNumb) ->
                new AuthorBookTitleSymbolCount(
                        result.getString(BOOK_FIELD_AUTHOR),
                        result.getInt("symbol_count")
                ));
    }

    public List<Book> getAllBooks() {
        String getAllBooksQuery = "SELECT * FROM BOOK";
        return jdbcTemplate.query(getAllBooksQuery, (result, rowNum) ->
                new Book(result.getLong(BOOK_FIELD_ID),
                        result.getString(BOOK_FIELD_TITLE),
                        result.getString(BOOK_FIELD_AUTHOR),
                        result.getString(BOOK_FIELD_DESCRIPTION)));
    }
}
