package com.onevizion.test.oneviziontest.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    List<Object[]> getBooksGroupedBy(@PathVariable String groupBy) {
        if (groupBy.equals("author")) {
            return queryService.findByAuthor();
        }
        return List.of();
    }

    @GetMapping("/list/4/{symbol}")             //todo change the name "4"
    Map<String, Integer> getAuthorBookCountBySymbolOccurrence(@PathVariable Character symbol) {
        return queryService.getAuthorBookCountBySymbolOccurrence(symbol);
    }

    @PostMapping("/add")
    void addBook(@RequestBody Book book) {
        queryService.save(book);
    }
}
