package apm.ds.userservice.service.imp;

import apm.ds.userservice.dto.ItemDto;
import apm.ds.userservice.dto.UserDto;
import apm.ds.userservice.dto.UserInfoDto;
import apm.ds.userservice.dto.UserItemsDto;
import apm.ds.userservice.entity.User;
import apm.ds.userservice.exception.ResourceNotFoundException;
import apm.ds.userservice.exception.UserAlreadyExistsException;
import apm.ds.userservice.mapper.UserMapper;
import apm.ds.userservice.repository.UserRepository;
import apm.ds.userservice.service.IUserService;
import apm.ds.userservice.service.client.AuctionserviceFeignClient;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final AuctionserviceFeignClient auctionserviceFeignClient;

    public UserServiceImpl(UserRepository userRepository, AuctionserviceFeignClient auctionserviceFeignClient) {
        this.userRepository = userRepository;
        this.auctionserviceFeignClient = auctionserviceFeignClient;
    }

    @Override
    public void createUser(UserDto userDto) {
        Optional<User> userOptional = userRepository.findByUsername(userDto.getUsername());
        if (userOptional.isPresent()) {
            throw new UserAlreadyExistsException(userDto.getUsername());
        }

        User user = UserMapper.mapToEntity(userDto, new User());
        userRepository.save(user);
    }

    @Override
    public UserInfoDto getUserInfoDto(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User", "username", username);
        }
        return UserMapper.mapToUserInfoDto(userOptional.get(), new UserInfoDto());
    }

    @Override
    public void update(UserDto userDto) {
        User userToUpdate = userRepository.findByUsername(userDto.getUsername())
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", userDto.getUsername()));

        User updatedUser = UserMapper.mapToEntity(userDto, userToUpdate);
        userRepository.save(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User", "username", username);
        }

        userRepository.removeUserByUsername(username);
    }

    @Override
    public UserItemsDto getUserItems(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("User", "username", username);
        }
        User user = userOptional.get();
        ResponseEntity<List<ItemDto>> responseItemDtoList = auctionserviceFeignClient.getItemsByUserId(user.getId());
        List<ItemDto> itemDtoList = responseItemDtoList.getBody();
        UserItemsDto userItemsDto = UserMapper.mapToUserItemsDto(user, new UserItemsDto());
        userItemsDto.setItemCount(itemDtoList==null? 0 : itemDtoList.size());
        userItemsDto.setItemDtoList(itemDtoList);
        return userItemsDto;
    }
}
