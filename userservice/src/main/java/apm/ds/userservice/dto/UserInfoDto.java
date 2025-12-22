package apm.ds.userservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "UserInfo", description = "Schema to hold all username, name and surname of a User")
public class UserInfoDto {

    @Schema(description = "Username of user", example = "tempUsername")
    private String username;

    @Schema(description = "Name of user", example = "tempName")
    private String name;

    @Schema(description = "Surname of user", example = "tempSurname")
    private String surname;

}
