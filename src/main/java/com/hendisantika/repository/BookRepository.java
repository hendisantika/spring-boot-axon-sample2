package com.hendisantika.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-axon-sample2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/11/21
 * Time: 07.29
 */
@Repository
public interface BookRepository extends CrudRepository<BookEntity, String> {
    List<BookEntity> findByLibraryId(Integer libraryId);
}
