package ru.files.cloud.service;

import ru.files.cloud.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long id);

    UserDto updateUser(UserDto userDto, Long id);

    void deleteUserById(Long id);

    UserDto findUserByLogin(String login);

}
