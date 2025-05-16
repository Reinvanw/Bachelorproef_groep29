package no_wire.no_wire.user.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import no_wire.no_wire.user.model.User;
import no_wire.no_wire.user.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null)
            throw new IllegalArgumentException("User not found");
        return user;
    }

    public User getUserById(long userId) {
        User user = userRepository.findById(userId);
        if (user == null)
            throw new IllegalArgumentException("User not found");
        return user;
    }
}