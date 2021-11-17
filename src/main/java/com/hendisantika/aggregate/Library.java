package com.hendisantika.aggregate;

import com.hendisantika.command.RegisterBookCommand;
import com.hendisantika.command.RegisterLibraryCommand;
import com.hendisantika.events.BookCreatedEvent;
import com.hendisantika.events.LibraryCreatedEvent;
import lombok.Data;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/11/21
 * Time: 07.21
 */
@Aggregate
@Data
public class Library {

    @AggregateIdentifier
    private Integer libraryId;

    private String name;

    private List<String> isbnBooks;

    protected Library() {
        // For Axon instantiation
    }

    @CommandHandler
    public Library(RegisterLibraryCommand cmd) {
        Assert.notNull(cmd.getLibraryId(), "ID should not be null");
        Assert.notNull(cmd.getName(), "Name should not be null");

        AggregateLifecycle.apply(new LibraryCreatedEvent(cmd.getLibraryId(), cmd.getName()));
    }

    @CommandHandler
    public void addBook(RegisterBookCommand cmd) {
        Assert.notNull(cmd.getLibraryId(), "ID should not be null");
        Assert.notNull(cmd.getIsbn(), "Book ISBN should not be null");

        AggregateLifecycle.apply(new BookCreatedEvent(cmd.getLibraryId(), cmd.getIsbn(), cmd.getTitle()));
    }

    @EventSourcingHandler
    private void handleCreatedEvent(LibraryCreatedEvent event) {
        libraryId = event.getLibraryId();
        name = event.getName();
        isbnBooks = new ArrayList<>();
    }
}
