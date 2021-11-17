package com.hendisantika.aggregate;

import lombok.Data;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

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

}
