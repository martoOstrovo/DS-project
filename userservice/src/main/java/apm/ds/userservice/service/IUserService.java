package apm.ds.userservice.service;

import apm.ds.userservice.dto.UserDto;
import apm.ds.userservice.dto.UserInfoDto;
import apm.ds.userservice.dto.UserItemsDto;

public interface IUserService {
    void createUser(UserDto userDto);

    UserInfoDto getUserInfoDto(String username);

    void update(UserDto userDto);

    void deleteUser(String username);

    UserItemsDto getUserItems(String username);
}
