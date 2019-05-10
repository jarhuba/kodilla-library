package com.kodilla.kodillalibrary.mapper;

import com.kodilla.kodillalibrary.domain.User;
import com.kodilla.kodillalibrary.domain.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getUserId(), userDto.getFirstName(), userDto.getLastName(), userDto.getRegistrationDate(), userDto.getRentalsForUser());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getRegistrationDate(), user.getRentalsForUser());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(user -> new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getRegistrationDate(), user.getRentalsForUser()))
                .collect(Collectors.toList());
    }
}
