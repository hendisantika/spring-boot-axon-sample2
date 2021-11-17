package com.hendisantika.events;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/11/21
 * Time: 07.24
 */
@Data
public class LibraryCreatedEvent {
    private final Integer libraryId;
    private final String name;
}
