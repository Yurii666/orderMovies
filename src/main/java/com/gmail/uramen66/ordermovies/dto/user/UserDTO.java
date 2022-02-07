package com.gmail.uramen66.ordermovies.dto.user;

import com.gmail.uramen66.ordermovies.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private int age;
    private Set<Role> roles;
}
