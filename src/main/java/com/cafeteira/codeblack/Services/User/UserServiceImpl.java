package com.cafeteira.codeblack.Services.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cafeteira.codeblack.Model.Entity.User;
import com.cafeteira.codeblack.Repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    @Override
    public Page<User> getUser(int page, int size) {
        return userRepo.findAll(PageRequest.of(page, size));
    }

    @Override
    public User postUser(UserDTO userDTO, String role) {
        User user = (role.equals("STAFF")) ? userDTO.addStaff(userDTO) : userDTO.addCostumer(userDTO);
        return userRepo.save(user);
    }

    @Override
    public User getUser(String username) {
        return userRepo.findByUsername(username).get();
    }
    
}
