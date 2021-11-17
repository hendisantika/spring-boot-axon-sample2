package com.hendisantika.queries;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/11/21
 * Time: 07.27
 */
@Data
public class GetBooksQuery {
    private final Integer libraryId;
}
