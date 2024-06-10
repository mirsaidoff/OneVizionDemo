package com.onevizion.test.oneviziontest.book.dao;

import com.onevizion.test.oneviziontest.book.model.AuthorBookTitleSymbolCount;
import com.onevizion.test.oneviziontest.book.model.AuthorBooks;
import com.onevizion.test.oneviziontest.book.model.Book;

import java.util.List;

public interface BookDao {
    public List<Book> getBooksByTitleDesc();

    public List<AuthorBooks> getAuthorBooks();

    public void save(final Book book);

    public List<AuthorBookTitleSymbolCount> getAuthorBookCountBySymbolOccurrence(String s);

    public List<Book> getAllBooks();
}
