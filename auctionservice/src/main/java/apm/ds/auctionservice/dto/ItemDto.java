package apm.ds.auctionservice.dto;

import apm.ds.auctionservice.annotation.IsNumber;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "item", description = "Schema to hold item information")
public class ItemDto {
    @Schema(description = "id of the item owner", example = "1231")
    @NotBlank(message = "Please enter owner id")
    @IsNumber(value = "^[0-9]+$", message = "please enter a valid id")
    private String userId;

    @Schema(description = "name of the item", example = "itemName")
    @NotBlank(message = "Please enter the item name.")
    private String itemName;

    @Schema(description = "item description", example = "item description example")
    @NotBlank(message = "Please enter the item description.")
    private String description;

    @Schema(description = "current price of the item", example = "1000$")
    @NotBlank(message = "Please enter the starting price.")
    @IsNumber
    private String currentPrice;

}
