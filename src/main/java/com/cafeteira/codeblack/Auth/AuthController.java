package com.cafeteira.codeblack.Auth;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafeteira.codeblack.Services.User.UserDTO;
import com.cafeteira.codeblack.Utils.GeneralUtilies;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/{role}")
    public ResponseEntity<Response> register(@RequestBody UserDTO userDTO, @PathVariable String role) {
        URI uri = GeneralUtilies.toUri("/register/{role}");
        return ResponseEntity.created(uri).body(authService.register(userDTO, role));
    }


    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody AuthDTO authDTO) {
        return ResponseEntity.ok().body(authService.login(authDTO));
    }
}
