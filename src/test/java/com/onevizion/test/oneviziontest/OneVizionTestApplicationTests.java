package com.onevizion.test.oneviziontest;

import com.onevizion.test.oneviziontest.book.controller.BookQueryController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OneVizionTestApplicationTests {

    @Autowired
    BookQueryController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
