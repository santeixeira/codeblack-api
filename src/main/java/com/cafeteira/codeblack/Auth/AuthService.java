package com.cafeteira.codeblack.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cafeteira.codeblack.Config.JwtService;
import com.cafeteira.codeblack.Model.Entity.User;
import com.cafeteira.codeblack.Services.User.UserDTO;
import com.cafeteira.codeblack.Services.User.UserService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDetailsService userDetailsService;

    public Response register(UserDTO userDTO, String role) {
        User user = userService.postUser(userDTO, role);
        System.out.println(user);
        String jwt = jwtService.generateToken(user);
        return Response.builder().token(jwt).build();
    }

    public Response login(AuthDTO authDTO) {
        authManager.authenticate(
            new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password())
        );
        var user = this.userDetailsService.loadUserByUsername(authDTO.login());
        String jwtToken = jwtService.generateToken(user);
        return Response.builder().token(jwtToken).build();
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class Response {
    private String token;
}
