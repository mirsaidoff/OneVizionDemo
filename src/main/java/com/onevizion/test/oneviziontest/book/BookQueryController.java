package com.onevizion.test.oneviziontest.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        if (groupBy.equals("author")) {
            return queryService.getBooksGroupedByAuthor();
        }
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
