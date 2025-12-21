package apm.ds.userservice.service.imp;

import apm.ds.userservice.dto.UserDto;
import apm.ds.userservice.entity.User;
import apm.ds.userservice.exception.UserAlreadyExistsException;
import apm.ds.userservice.mapper.UserMapper;
import apm.ds.userservice.repository.UserRepository;
import apm.ds.userservice.service.IUserService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = UserMapper.mapToEntity(userDto, new User());

        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException(userDto.getUsername());
        }

        userRepository.save(user);
    }
}
