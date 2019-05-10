package com.kodilla.kodillalibrary.services;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserDbService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(final Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteById(final Long id) {
        userRepository.deleteById(id);
    }
}
