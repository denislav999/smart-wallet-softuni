package app.web.dto;

import app.user.model.Country;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record RegisterRequest  (
        @Size(min = 6, max = 24, message = "Username length can be between 6 and 24 symbols!")
        @NotBlank
        String username,

        @Size(min = 6, max = 6, message = "Password must be exactly 6 symbols!")
        @NotBlank
        String password,

        @NotNull
        Country country) {
}

