package com.onevizion.test.oneviziontest.book.dao;

import com.onevizion.test.oneviziontest.book.model.AuthorBookTitleSymbolCount;
import com.onevizion.test.oneviziontest.book.model.AuthorBooks;
import com.onevizion.test.oneviziontest.book.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-integration.properties")
class BookDaoTest {

    private final Book dummy_first = new Book.Builder()
            .title("Aaaa")
            .author("Author1")
            .build();

    private final Book dummy_last = new Book.Builder()
            .title("Zzzz")
            .author("Author2")
            .build();

    @Autowired
    BookDaoImpl bookDao;

    @Test
    void getAllReturnsAllBooks() {
        List<Book> allBooks = bookDao.getAllBooks();
        assertEquals(5, allBooks.size());
    }

    @Test
    void getBooksByTitleDescReturnsCorrectData() {
        bookDao.save(dummy_first);
        bookDao.save(dummy_last);
        List<Book> booksByTitleDesc = bookDao.getBooksByTitleDesc();
        assertEquals(dummy_last.getTitle(), booksByTitleDesc.get(0).getTitle());
        assertEquals(dummy_first.getTitle(), booksByTitleDesc.get(booksByTitleDesc.size() - 1).getTitle());
    }

    @Test
    void getBookByTitleReturnsCorrectData() {
        List<AuthorBooks> authorBooks = bookDao.getAuthorBooks();
        assertEquals(3, authorBooks.size());
    }

    @Test
    void getBookByIdReturnsCorrectData() {
        List<AuthorBookTitleSymbolCount> res = bookDao.getAuthorBookCountBySymbolOccurrence("a");
        assertEquals(3, res.size());
        assertEquals(7, res.get(0).occurrenceCount());
        assertEquals(4, res.get(1).occurrenceCount());
        assertEquals(1, res.get(2).occurrenceCount());

        res = bookDao.getAuthorBookCountBySymbolOccurrence("c");
        assertEquals(2, res.size());
        assertEquals(1, res.get(0).occurrenceCount());
        assertEquals(1, res.get(1).occurrenceCount());

    }
}