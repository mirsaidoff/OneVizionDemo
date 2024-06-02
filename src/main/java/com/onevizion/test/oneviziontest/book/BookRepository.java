package com.onevizion.test.oneviziontest.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    //todo move the logic to the service
    @Query("""
            SELECT a.author, GROUP_CONCAT(a.title) AS book_list
            FROM Book a
            GROUP BY a.author
            """)
    List<Object[]> countTotalAuthorBooks();
}
