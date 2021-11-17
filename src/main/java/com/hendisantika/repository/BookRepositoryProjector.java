package com.hendisantika.repository;

import com.hendisantika.events.BookCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;

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
}
