package com.onevizion.test.oneviziontest;

import com.onevizion.test.oneviziontest.book.dao.BookDao;
import com.onevizion.test.oneviziontest.book.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseSeeder {

    @Autowired
    BookDao bookDao;

    public void insertInitialData() {
        bookDao.save(new Book(
                "Crime and Punishment",
                "F. Dostoevsky",
                null
        ));

        bookDao.save(new Book(
                "Anna Karenina",
                "L. Tolstoy",
                null
        ));

        bookDao.save(new Book(
                "The Brothers Karamazov",
                "F. Dostoevsky",
                null
        ));

        bookDao.save(new Book(
                "War and Peace",
                "L. Tolstoy",
                null
        ));

        bookDao.save(new Book(
                "Dead Souls",
                "N. Gogol",
                null
        ));
    }
}
