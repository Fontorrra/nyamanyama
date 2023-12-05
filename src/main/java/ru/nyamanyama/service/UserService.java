package ru.nyamanyama.service;

import org.springframework.stereotype.Service;
import ru.nyamanyama.domain.User;
import ru.nyamanyama.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Boolean updateUser(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            userRepository.save(user);
            return true;
        }
        return false;
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
