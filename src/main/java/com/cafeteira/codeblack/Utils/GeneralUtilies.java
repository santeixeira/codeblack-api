package com.cafeteira.codeblack.Utils;

import java.net.URI;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public interface GeneralUtilies {
    public static URI toUri(String path) {
        return URI.create(ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .path(path)
        .toString());
    }

    public static String encode(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}
