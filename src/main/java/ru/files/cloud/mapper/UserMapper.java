package ru.files.cloud.mapper;

import org.mapstruct.Mapper;
import ru.files.cloud.dto.UserDto;
import ru.files.cloud.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

}
