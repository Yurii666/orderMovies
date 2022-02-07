package com.gmail.uramen66.ordermovies.dto.user;

import com.gmail.uramen66.ordermovies.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface UserMapper {
    default UserDTO userToUserDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .age(user.getAge())
                .roles(user.getRoles())
                .build();
    }
    default User userDtoToUser(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .name(userDTO.getName())
                .surname(userDTO.getSurname())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .age(userDTO.getAge())
                .roles(userDTO.getRoles())
                .build();
        }
    default Page<UserDTO> userToUserDTOs (Page<User> users){

        return users.map(this::userToUserDto);
    }
}
