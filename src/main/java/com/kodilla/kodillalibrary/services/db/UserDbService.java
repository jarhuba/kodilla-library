package com.kodilla.kodillalibrary.services.db;

import com.kodilla.kodillalibrary.controller.exception.UserNotFoundException;
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

    public User findUserById(final Long id) throws UserNotFoundException {
        return userRepository.findUserByUserId(id).orElseThrow(UserNotFoundException::new);
    }

    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public void deleteById(final Long id) {
        userRepository.deleteById(id);
    }
}
