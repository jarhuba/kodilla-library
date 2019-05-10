package com.kodilla.kodillalibrary.repository;

import com.kodilla.kodillalibrary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
