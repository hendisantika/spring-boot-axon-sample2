package com.hendisantika.repository;

import com.hendisantika.aggregate.Library;
import lombok.RequiredArgsConstructor;
import org.axonframework.modelling.command.Repository;
import org.springframework.stereotype.Service;

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

}
