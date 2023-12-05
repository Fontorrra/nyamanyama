package ru.nyamanyama.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nyamanyama.domain.User;
import ru.nyamanyama.exception.IdDoesNotExistsException;
import ru.nyamanyama.exception.UserDoesNotExistsException;
import ru.nyamanyama.service.UserService;

import javax.validation.Valid;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) throws IdDoesNotExistsException {
        log.info("Received PUT request to endpoint /users with body {}", user);
        if (userService.updateUser(user)){
            log.info("User {} updated successfully", user);
        }
        else {
            log.warn("User with id {} does not exists", user.getId());
            throw new UserDoesNotExistsException("User with id " + user.getId() + " does not exists");
        }
        return user;
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        log.info("Received POST request to endpoint /users with body {}", user);
        user = userService.createUser(user);
        log.info("User {} added successfully", user);
        return user;
    }


    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) throws UserDoesNotExistsException {
        log.info("Received GET request to endpoint /users/{}", id);
        Optional<User> user = userService.getUser(id);
        if (user.isEmpty()) {
            log.warn("User with id {} does not exists", id);
            throw new UserDoesNotExistsException("User with id " + id + " does not exists");
        }
        return user.get();
    }
}