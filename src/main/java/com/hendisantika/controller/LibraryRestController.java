package com.hendisantika.controller;

import com.hendisantika.command.RegisterLibraryCommand;
import com.hendisantika.models.LibraryBean;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
