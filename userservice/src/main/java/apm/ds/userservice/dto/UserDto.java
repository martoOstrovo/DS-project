package apm.ds.userservice.dto;

import apm.ds.userservice.annotation.PasswordComplex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "Please enter your name.")
    private String username;
    @NotBlank(message = "Please enter your name.")
    private String name;
    @NotBlank(message = "Please enter your name.")
    private String surname;
    @Email(message = "Please enter a valid email address.")
    @NotBlank(message = "Please enter your email address.")
    private String email;
    @PasswordComplex
    @NotBlank(message = "Please enter your password.")
    private String password;
}
