package com.hendisantika.repository;

import com.hendisantika.events.BookCreatedEvent;
import com.hendisantika.models.BookBean;
import com.hendisantika.queries.GetBooksQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/11/21
 * Time: 07.29
 */
@Service
@RequiredArgsConstructor
public class BookRepositoryProjector {

    private final BookRepository bookRepository;

    @EventHandler
    public void addBook(BookCreatedEvent event) throws Exception {
        BookEntity book = new BookEntity();
        book.setIsbn(event.getIsbn());
        book.setLibraryId(event.getLibraryId());
        book.setTitle(event.getTitle());
        bookRepository.save(book);
    }

    @QueryHandler
    public List<BookBean> getBooks(GetBooksQuery query) {
        return bookRepository.findByLibraryId(query.getLibraryId()).stream().map(toBook()).collect(Collectors.toList());
    }

    private Function<BookEntity, BookBean> toBook() {
        return e -> {
            BookBean book = new BookBean();
            book.setIsbn(e.getIsbn());
            book.setTitle(e.getTitle());
            return book;
        };
    }
}
