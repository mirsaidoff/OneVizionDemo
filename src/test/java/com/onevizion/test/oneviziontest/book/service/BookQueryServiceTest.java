package com.onevizion.test.oneviziontest.book.service;

import com.onevizion.test.oneviziontest.book.dao.BookDao;
import com.onevizion.test.oneviziontest.book.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookQueryServiceTest {

    @Mock
    private BookDao bookDao;

    private BookQueryService service = new BookQueryService(bookDao);

    @BeforeEach
    void setUp() {
        service = new BookQueryService(bookDao);
    }

    @Test
    void test_getAllBooksByTitleDesc_callsCorrectMethod() {
        List<Book> res = List.of();
        when(bookDao.getBooksByTitleDesc()).thenReturn(res);
        service.getAllBooksByTitleDesc();
        verify(bookDao, times(1)).getBooksByTitleDesc();
        assertEquals(res, service.getAllBooksByTitleDesc());
    }

    @Test
    void test_getAuthorBooks_callsCorrectMethod() {
        service.getBooksGroupedByAuthor();
        verify(bookDao, times(1)).getAuthorBooks();
    }

    @Test
    void test_getAuthorBookCountBySymbolOccurrence_callsCorrectMethod() {
        service.getAuthorBookCountBySymbolOccurrence(anyString());
        verify(bookDao, times(1)).getAuthorBookCountBySymbolOccurrence(anyString());
    }

    @Test
    void test_save_callsCorrectMethod() {
        service.save(any());
        verify(bookDao, times(1)).save(any());
    }

}