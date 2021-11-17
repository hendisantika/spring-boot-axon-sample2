package com.hendisantika.controller;

import com.hendisantika.aggregate.Library;
import com.hendisantika.command.RegisterBookCommand;
import com.hendisantika.command.RegisterLibraryCommand;
import com.hendisantika.models.BookBean;
import com.hendisantika.models.LibraryBean;
import com.hendisantika.queries.GetBooksQuery;
import com.hendisantika.queries.GetLibraryQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/11/21
 * Time: 07.33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/libraries")
public class LibraryRestController {

    private final CommandGateway commandGateway;
    private final QueryGateway queryGateway;

    @PostMapping
    public String addLibrary(@RequestBody LibraryBean library) {
        commandGateway.send(new RegisterLibraryCommand(library.getLibraryId(), library.getName()));
        return "Saved";
    }

    @GetMapping("/{library}")
    public Library getLibrary(@PathVariable Integer library) throws InterruptedException, ExecutionException {
        CompletableFuture<Library> future = queryGateway.query(new GetLibraryQuery(library), Library.class);
        return future.get();
    }

    @PostMapping("/{library}/book")
    public String addBook(@PathVariable Integer library, @RequestBody BookBean book) {
        commandGateway.send(new RegisterBookCommand(library, book.getIsbn(), book.getTitle()));
        return "Saved";
    }

    @GetMapping("/{library}/book")
    public List<BookBean> addBook(@PathVariable Integer library) throws InterruptedException, ExecutionException {
        return queryGateway.query(new GetBooksQuery(library), ResponseTypes.multipleInstancesOf(BookBean.class)).get();
    }
}
