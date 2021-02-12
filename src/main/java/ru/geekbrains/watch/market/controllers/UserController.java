package ru.geekbrains.watch.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.watch.market.model.User;
import ru.geekbrains.watch.market.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User saveOrUpdate(@RequestBody User user) {
        user.setId(null);
        return userService.saveOrUpdate(user);
    }
}
