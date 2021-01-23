package ru.geekbrains.watch.market.repositories;

import java.util.Optional;

public interface UserRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
