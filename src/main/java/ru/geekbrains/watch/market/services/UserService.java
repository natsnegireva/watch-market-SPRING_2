package ru.geekbrains.watch.market.services;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.User;
import org.springframework.stereotype.Service;
import ru.geekbrains.watch.market.repositories.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername (username);
    }
}
