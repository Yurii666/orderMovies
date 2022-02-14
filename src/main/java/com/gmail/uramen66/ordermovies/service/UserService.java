package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.user.UserDTO;
import com.gmail.uramen66.ordermovies.dto.user.UserMapper;
import com.gmail.uramen66.ordermovies.enums.StatusType;
import com.gmail.uramen66.ordermovies.exception.ResourceNotFoundException;
import com.gmail.uramen66.ordermovies.model.User;
import com.gmail.uramen66.ordermovies.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.gmail.uramen66.ordermovies.enums.StatusType.ACTIVE;
import static com.gmail.uramen66.ordermovies.enums.StatusType.DELETED;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO createUser(UserDTO userDTO){
        User user = User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .roles(userDTO.getRoles())
                .age(userDTO.getAge())
                .created(Timestamp.valueOf(LocalDateTime.now()))
                .update(Timestamp.valueOf(LocalDateTime.now()))
                .status(StatusType.ACTIVE)
                .build();

        User saveUser = userRepository.saveAndFlush(user);
        return userMapper.userToUserDto(saveUser);

    }
    public UserDTO findUserByIdAndStatus(Long id) {
        return userRepository
                .findByIdAndStatus(id, StatusType.ACTIVE)
                .map(userMapper::userToUserDto)
                .orElseThrow(ResourceNotFoundException ::new);
    }

    public UserDTO findUserById(Long id) {
        return userRepository
                .findById(id)
                .map(userMapper::userToUserDto)
                .orElseThrow(ResourceNotFoundException ::new);
    }

    public void deleteUser(Long id) {
        User user = userRepository.findByIdAndStatus(id, StatusType.ACTIVE)
                .orElseThrow(ResourceNotFoundException ::new);
        user.setStatus(DELETED);
        userRepository.saveAndFlush(user);
    }
    public Page<UserDTO> findAllUsers(Pageable pageable){
        return userMapper.userToUserDTOs(userRepository.findAll(pageable));
    }
    public UserDTO updateUser(Long id, UserDTO userDTO ){
        User userUpdateById = userRepository.findByIdAndStatus(id, ACTIVE)
                .orElseThrow(ResourceNotFoundException::new);

        User actualUser = userMapper.userDtoToUser(userDTO);
        userUpdateById.setName(actualUser.getName());
        userUpdateById.setSurname(actualUser.getSurname());
        userUpdateById.setUsername(actualUser.getUsername());
        userUpdateById.setPassword(actualUser.getPassword());
        userUpdateById.setEmail(actualUser.getEmail());
        userUpdateById.setPhoneNumber(actualUser.getPhoneNumber());
        userUpdateById.setAge(actualUser.getAge());

        return userMapper.userToUserDto(userRepository.save(userUpdateById));
    }
}
