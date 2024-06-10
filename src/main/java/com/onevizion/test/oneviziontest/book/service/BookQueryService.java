package com.onevizion.test.oneviziontest.book.service;

import com.onevizion.test.oneviziontest.book.dao.BookDao;
import com.onevizion.test.oneviziontest.book.model.AuthorBookTitleSymbolCount;
import com.onevizion.test.oneviziontest.book.model.AuthorBooks;
import com.onevizion.test.oneviziontest.book.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookQueryService {

    private final BookDao bookDao;

    BookQueryService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getAllBooksByTitleDesc() {
        return bookDao.getBooksByTitleDesc();
    }

    public List<AuthorBooks> getBooksGroupedByAuthor() {
        return bookDao.getAuthorBooks();
    }

    public List<AuthorBookTitleSymbolCount> getAuthorBookCountBySymbolOccurrence(String symbol) {
        return bookDao.getAuthorBookCountBySymbolOccurrence(symbol);
    }

    public void save(Book book) {
        bookDao.save(book);
    }

}
