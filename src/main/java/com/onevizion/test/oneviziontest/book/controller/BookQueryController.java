package com.onevizion.test.oneviziontest.book.controller;

import com.onevizion.test.oneviziontest.book.service.BookQueryService;
import com.onevizion.test.oneviziontest.book.model.AuthorBookTitleSymbolCount;
import com.onevizion.test.oneviziontest.book.model.AuthorBooks;
import com.onevizion.test.oneviziontest.book.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.onevizion.test.oneviziontest.book.model.Book.BOOK_FIELD_AUTHOR;

@RestController
@RequestMapping("book/v1")
public class BookQueryController {

    private final BookQueryService queryService;

    public BookQueryController(BookQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/list-ordered/title/desc")
    public List<Book> listOrderedTitleDesc() {
        return queryService.getAllBooksByTitleDesc();
    }


    @GetMapping("/list/{groupBy}")
    List<AuthorBooks> getBooksGroupedBy(@PathVariable String groupBy) {
        List<AuthorBooks> result;

        if (groupBy.equals(BOOK_FIELD_AUTHOR)) {
            result = queryService.getBooksGroupedByAuthor();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No results found for " + groupBy);
        }

        return result;
    }

    @GetMapping("/list/author-book-symbol-count")
    List<AuthorBookTitleSymbolCount> getAuthorBookCountBySymbolOccurrence(@RequestParam(name = "symbol") String symbol) {
        return queryService.getAuthorBookCountBySymbolOccurrence(symbol);
    }

    @PostMapping("/add")
    void addBook(@RequestBody Book book) {
        queryService.save(book);
    }
}
