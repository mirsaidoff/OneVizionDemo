package com.onevizion.test.oneviziontest.book;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookQueryService {

    private final BookRepository bookRepository;
    private final BookDao bookDao;

    BookQueryService(BookRepository bookRepository, BookDao bookDao) {
        this.bookRepository = bookRepository;
        this.bookDao = bookDao;
    }

    public List<Book> getAllBooksByTitleDesc(){
        return bookDao.getBooksByTitleDesc();
    }

    public List<Object[]> findByAuthor() {
        return bookRepository.countTotalAuthorBooks();
    }

    public Map<String, Integer> getAuthorBookCountBySymbolOccurrence(Character symbol) {
        return bookRepository.findAll().stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor, // Group by author
                        Collectors.summingInt(book -> countOccurrences(book.getTitle(), symbol))
                ));
    }

    private static int countOccurrences(String str, Character symbol) {
        return (int) str.toLowerCase().chars()
                .filter(ch -> ch == symbol)
                .count();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

}
