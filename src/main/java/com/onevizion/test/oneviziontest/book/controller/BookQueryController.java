package com.onevizion.test.oneviziontest.book.controller;

import com.onevizion.test.oneviziontest.book.service.BookQueryService;
import com.onevizion.test.oneviziontest.book.model.AuthorBookTitleSymbolCount;
import com.onevizion.test.oneviziontest.book.model.AuthorBooks;
import com.onevizion.test.oneviziontest.book.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.onevizion.test.oneviziontest.book.model.Book.BOOK_FIELD_AUTHOR;

@RestController
@RequestMapping("book/v1")
public class BookQueryController {

    private final BookQueryService queryService;
    private final BookQueryService bookQueryService;

    public BookQueryController(BookQueryService queryService, BookQueryService bookQueryService) {
        this.queryService = queryService;
        this.bookQueryService = bookQueryService;
    }

    @GetMapping("/list-ordered/title/desc")
    public List<Book> listOrderedTitleDesc() {
        return bookQueryService.getAllBooksByTitleDesc();
    }


    @GetMapping("/list/{groupBy}")
    List<AuthorBooks> getBooksGroupedBy(@PathVariable String groupBy) {
        if (groupBy.equals(BOOK_FIELD_AUTHOR)) {
            return queryService.getBooksGroupedByAuthor();
        }
        //made it as much as flexible, so we could handle other group-by cases here

        return List.of();
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
