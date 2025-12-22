package apm.ds.userservice.service;

import apm.ds.userservice.dto.UserDto;
import apm.ds.userservice.dto.UserInfoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public interface IUserService {
    void createUser(UserDto userDto);

    UserInfoDto getUserInfoDto(String username);

    void update(UserDto userDto);

    void deleteUser(String username);
}
