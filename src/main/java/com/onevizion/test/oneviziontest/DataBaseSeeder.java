package com.onevizion.test.oneviziontest;

import com.onevizion.test.oneviziontest.book.dao.BookDaoImpl;
import com.onevizion.test.oneviziontest.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseSeeder {

    @Autowired
    BookDaoImpl bookDao;

    public void insertInitialData() {
        bookDao.save(new Book.Builder()
                .title("Crime and Punishment")
                .author("F. Dostoevsky")
                .build());

        bookDao.save(new Book.Builder()
                .title("Anna Karenina")
                .author("L. Tolstoy")
                .build());

        bookDao.save(new Book.Builder()
                .title("The Brothers Karamazov")
                .author("F. Dostoevsky")
                .build());

        bookDao.save(new Book.Builder()
                .title("War and Peace")
                .author("L. Tolstoy")
                .build());

        bookDao.save(new Book.Builder()
                .title("Dead Souls")
                .author("N. Gogol")
                .build());
    }
}
