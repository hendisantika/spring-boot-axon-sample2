package com.hendisantika.events;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/11/21
 * Time: 07.25
 */
@Data
public class BookCreatedEvent {
    @TargetAggregateIdentifier
    private final Integer libraryId;
    private final String isbn;
    private final String title;
}
