package com.cafeteira.codeblack.Auth;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AuthDTO(@NotNull @NotEmpty String login, @NotNull @NotEmpty String password) {
    
}
