package com.rentcar.controller;



import com.rentcar.model.User;
import com.rentcar.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {
    private static final Logger logger = Logger.getLogger(UserController.class.getName());
    private final UserRepository repository;

    @Autowired
    UserController(final UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    List <User> all() {
        logger.info("Finding all users");
        return repository.findAll();
    }

    @PostMapping("/adduser")
    ResponseEntity <?> addUser(@RequestBody @Valid User userToAdd) {
        final User save = repository.save(userToAdd);
        return ResponseEntity.created(URI.create("/" + save.getId())).body(save);
    }


}
