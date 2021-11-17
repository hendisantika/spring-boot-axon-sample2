package com.hendisantika.repository;

import com.hendisantika.aggregate.Library;
import com.hendisantika.queries.GetLibraryQuery;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.Repository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/11/21
 * Time: 07.31
 */
@Service
@RequiredArgsConstructor
public class LibraryProjector {
    private final Repository<Library> libraryRepository;

    @QueryHandler
    public Library getLibrary(GetLibraryQuery query) throws InterruptedException, ExecutionException {
        CompletableFuture<Library> future = new CompletableFuture<Library>();
        libraryRepository.load("" + query.getLibraryId()).execute(future::complete);
        return future.get();
    }

}
