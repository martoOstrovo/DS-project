package apm.ds.userservice.dto;

import apm.ds.userservice.annotation.PasswordComplex;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "User", description = "Schema to hold all User information")
public class UserDto {

    @NotBlank(message = "Please enter your name.")
    @Schema(description = "Username of user", example = "tempUsername")
    private String username;

    @NotBlank(message = "Please enter your name.")
    @Schema(description = "Name of user", example = "tempName")
    private String name;

    @NotBlank(message = "Please enter your name.")
    @Schema(description = "Surname of user", example = "tempSurname")
    private String surname;

    @Email(message = "Please enter a valid email address.")
    @NotBlank(message = "Please enter your email address.")
    @Schema(description = "Email of user", example = "tempMail@gmail.com")
    private String email;

    @PasswordComplex
    @NotBlank(message = "Please enter your password.")
    @Schema(description = "Password of user", example = "tempTemp123!")
    private String password;

}
