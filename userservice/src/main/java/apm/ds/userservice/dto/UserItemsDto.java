package apm.ds.userservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserItemsDto {

    @NotBlank(message = "Please enter your name.")
    @Schema(description = "Username of user", example = "tempUsername")
    private String username;

    @Schema(description = "Number of items that the user has", example = "1")
    private int itemCount;

    @Schema(description = "Items that the owner has")
    private List<ItemDto> itemDtoList;

}
