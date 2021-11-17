package com.hendisantika.repository;

import lombok.RequiredArgsConstructor;
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

}
