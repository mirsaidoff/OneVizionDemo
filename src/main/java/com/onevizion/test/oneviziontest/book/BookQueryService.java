package com.onevizion.test.oneviziontest.book;

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
