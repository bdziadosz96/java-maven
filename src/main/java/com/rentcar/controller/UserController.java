package com.rentcar.controller;



import com.rentcar.model.User;
import com.rentcar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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
    List<User> all() {
        logger.info("Finding all users");
        return repository.findAll();
    }

    @PostMapping("/add/user")
    ResponseEntity<?> addUser(@RequestBody @Valid User userToAdd) {
        final User save = repository.save(userToAdd);
        return ResponseEntity.created(URI.create("/" + save.getId())).body(save);
    }

    @Transactional
    @DeleteMapping("/delete/user/{id}")
    ResponseEntity<?> deleteUser(@PathVariable Long id) {
        if (repository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            repository.delete(repository.findById(id).get());
            return ResponseEntity.ok().build();
        }
    }

    @PatchMapping("/update/user/{id}")
    ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userToUpdate) {
        if (repository.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            final User user = repository.findById(id).get();
            user.updateFrom(userToUpdate);
            repository.save(user);
            return ResponseEntity.ok().build();
        }
    }
}

