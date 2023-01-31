package com.cafeteira.codeblack.Services.User;

import org.springframework.data.domain.Page;

import com.cafeteira.codeblack.Model.Entity.User;

public interface UserService {
    Page<User> getUser(int page, int size);
    User postUser(UserDTO userDTO, String role);
    User getUser(String username);
}
