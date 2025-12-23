package apm.ds.userservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "item", description = "Schema to hold item information")
public class ItemDto {
    @Schema(description = "id of the item owner", example = "1231")
    @Positive(message = "user id must be a positive integer value")
    private Long userId;

    @Schema(description = "name of the item", example = "itemName")
    @NotBlank(message = "Please enter the item name.")
    private String itemName;

    @Schema(description = "item description", example = "item description example")
    @NotBlank(message = "Please enter the item description.")
    private String description;

    @Schema(description = "current price of the item", example = "1000$")
    @PositiveOrZero(message = "price must be positive or zero")
    private Double currentPrice;

}
