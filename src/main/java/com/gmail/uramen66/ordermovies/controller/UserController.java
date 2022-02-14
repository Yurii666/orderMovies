package com.gmail.uramen66.ordermovies.controller;

import com.gmail.uramen66.ordermovies.dto.user.UserDTO;
import com.gmail.uramen66.ordermovies.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
private final UserService userService;

    @GetMapping
        public Page<UserDTO> findAllUsers(@PageableDefault (sort = {"id"}, direction = Sort.Direction.ASC, size = 20)Pageable page){
        return userService.findAllUsers(page);
    }

    @GetMapping("{id}")
    public UserDTO findById(@PathVariable long id){
        return userService.findUserById(id);
    }

    @PostMapping
    public UserDTO createUser(UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable long id, UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id, UserDTO userDTO){
        userService.deleteUser(id);
    }

}
