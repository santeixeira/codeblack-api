package com.cafeteira.codeblack.Services;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.UniqueElements;

import com.cafeteira.codeblack.Model.Enum.CategoryEnum;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductDTO(
        @NotNull @NotEmpty String title,
        @NotNull @NotEmpty String description,
        @NotNull @URL String photo,
        @NotNull Integer size,
        @NotNull @DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 3, fraction = 2) BigDecimal price,
        @NotNull Integer preparation,
        @NotNull CategoryEnum categoryId) {
}
