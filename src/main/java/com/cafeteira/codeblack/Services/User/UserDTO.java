package com.cafeteira.codeblack.Services.User;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import com.cafeteira.codeblack.Model.Entity.User;
import com.cafeteira.codeblack.Model.Enum.RoleEnum;
import com.cafeteira.codeblack.Utils.GeneralUtilies;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UserDTO(@NotNull @NotEmpty @Email String email,
        @NotNull @NotEmpty @Length(min = 5, max = 15) String username,
        @NotNull @NotEmpty String password) {
    public User addCostumer(UserDTO userDTO) {
        return new User(null,
                null,
                this.username,
                this.password,
                LocalDateTime.now(),
                LocalDateTime.now(),
                RoleEnum.COSTUMER);
    }

    public User addStaff(UserDTO userDTO) {
        return new User(null,
                this.email,
                this.username,
                GeneralUtilies.encode(this.password),
                LocalDateTime.now(),
                LocalDateTime.now(),
                RoleEnum.STAFF);
    }
}
