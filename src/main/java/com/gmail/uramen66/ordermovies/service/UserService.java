package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.user.UserDTO;
import com.gmail.uramen66.ordermovies.dto.user.UserMapper;
import com.gmail.uramen66.ordermovies.enums.StatusType;
import com.gmail.uramen66.ordermovies.model.User;
import com.gmail.uramen66.ordermovies.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.gmail.uramen66.ordermovies.enums.StatusType.DELETED;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private UserMapper userMapper;

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
    public UserDTO findUserByIdAndStatus(Long id) throws Exception{
        return userRepository
                .findByIdAndStatus(id, StatusType.ACTIVE)
                .map(userMapper::userToUserDto)
                .orElseThrow(Exception::new);
    }
    public void deleteUser(Long id) throws Exception{
        User user = userRepository.findByIdAndStatus(id, StatusType.ACTIVE)
                .orElseThrow(Exception::new);
        user.setStatus(DELETED);
        userRepository.saveAndFlush(user);
    }
    public Page<UserDTO> findByUsers(Pageable pageable){
        return userMapper.userToUserDTOs(userRepository.findAll(pageable));
    }
}
