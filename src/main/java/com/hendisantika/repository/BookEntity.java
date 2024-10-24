package com.hendisantika.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/11/21
 * Time: 07.28
 */
@Entity
@Data
public class BookEntity {
    @Id
    private String isbn;
    @Column
    private int libraryId;
    @Column
    private String title;
}
