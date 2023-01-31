package com.cafeteira.codeblack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafeteira.codeblack.Model.Entity.User;
import com.cafeteira.codeblack.Services.User.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<Page<User>> getUsers(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.ok().body(userService.getUser(page, size));
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<User> show(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUser(username));
    }

}
