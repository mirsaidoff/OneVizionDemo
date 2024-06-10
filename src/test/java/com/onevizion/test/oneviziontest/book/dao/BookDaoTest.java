package com.onevizion.test.oneviziontest.book.dao;

import com.onevizion.test.oneviziontest.book.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookDaoTest {

    private Book dummy_one = new Book("Title1", "Author1", null);
    private Book dummy_two = new Book("Title2", "Author2", null);
    private Book dummy_three = new Book("Title3", "Author1", null);
    private Book dummy_four = new Book("Title4", "Author2", null);

    @Autowired
    BookDao bookDao;

    @BeforeEach
    void setUp() {
        bookDao.save(dummy_one);
        bookDao.save(dummy_two);
        bookDao.save(dummy_three);
    }

    @Test
    void getAllReturnsAllBooks() {
        List<Book> allBooks = bookDao.getAllBooks();
        assertEquals(3, allBooks.size());
    }

    @Test
    void getBooksByTitleDescReturnsCorrectData() {
        List<Book> booksByTitleDesc = bookDao.getBooksByTitleDesc();

        assertEquals(dummy_three, booksByTitleDesc.get(0));
        assertEquals(dummy_two, booksByTitleDesc.get(1));
        assertEquals(dummy_three, booksByTitleDesc.get(2));

        bookDao.save(dummy_four);
        booksByTitleDesc = bookDao.getBooksByTitleDesc();

        assertEquals(dummy_four, booksByTitleDesc.get(0));
    }
}