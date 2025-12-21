package apm.ds.userservice.mapper;

import apm.ds.userservice.dto.UserDto;
import apm.ds.userservice.dto.UserInfoDto;
import apm.ds.userservice.entity.User;

public class UserMapper {
    public static User mapToEntity(UserDto userDto, User user) {
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static UserDto mapToUserDto (User user, UserDto userDto) {
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static UserInfoDto mapToUserInfoDto(User user, UserInfoDto userInfoDto) {
        userInfoDto.setName(user.getName());
        userInfoDto.setSurname(user.getSurname());
        userInfoDto.setUsername(user.getUsername());
        return userInfoDto;
    }
}
