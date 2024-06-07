package com.onevizion.test.oneviziontest;

import com.onevizion.test.oneviziontest.book.dao.BookDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneVizionTestApplication implements CommandLineRunner {

    @Autowired
    private DataBaseSeeder databaseSeeder;
    @Autowired
    private BookDao bookDao;

    public static void main(String[] args) {
        SpringApplication.run(OneVizionTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        databaseSeeder.insertInitialData();
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info("Checking initial data being inserted into DB");
        bookDao.getAllBooks().forEach(
                book -> {
                    logger.info(book.toString());
                }
        );
    }
}
