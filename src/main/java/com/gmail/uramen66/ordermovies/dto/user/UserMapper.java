package com.gmail.uramen66.ordermovies.dto.user;

import com.gmail.uramen66.ordermovies.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface UserMapper {
    UserDTO userToUserDto(User user);

    User userDtoToUser(UserDTO userDTO);

}
