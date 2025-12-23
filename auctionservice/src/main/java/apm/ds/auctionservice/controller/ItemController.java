package apm.ds.auctionservice.controller;

import apm.ds.auctionservice.constants.ItemConstants;
import apm.ds.auctionservice.dto.ErrorResponseDto;
import apm.ds.auctionservice.dto.ItemDto;
import apm.ds.auctionservice.dto.ResponseDto;
import apm.ds.auctionservice.service.IItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/items", produces = {MediaType.APPLICATION_JSON_VALUE})
@Valid
public class ItemController {
    private final IItemService itemService;

    public ItemController(IItemService itemService) {
        this.itemService = itemService;
    }

    @Operation(
            summary = "Create Item",
            description = "REST API call to create a item"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "201",
                            description = "HTTP status CREATED"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP status INTERNAL SERVER ERROR",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
                    )
            }
    )
    @PostMapping("/create-item")
    public ResponseEntity<ResponseDto> createItem (@Valid @RequestBody ItemDto itemDto) {
        itemService.createItem(itemDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ItemConstants.STATUS_201, ItemConstants.MESSAGE_201));
    }


    @Operation(
            summary = "Read Item",
            description = "REST API call to get an item by their item name"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP status OK"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP status INTERNAL SERVER ERROR",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
                    )
            }
    )
    @GetMapping("/get-item")
    public ResponseEntity<ItemDto> getItem(@NotBlank(message = "Please enter the name of your item.")
                                               @RequestParam
                                               String itemName) {

        ItemDto itemDto = itemService.getItemDto(itemName);
        return ResponseEntity
                .ok()
                .body(itemDto);
    }

    @Operation(
            summary = "Read Item",
            description = "REST API call to get an items by their user ID"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP status OK"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP status INTERNAL SERVER ERROR",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
                    )
            }
    )
    @GetMapping("/get-items")
    public ResponseEntity<List<ItemDto>> getItemsByUserId(@Positive(message = "user id must be a positive integer value")
                                                              @RequestParam
                                                              Long userId) {

        List<ItemDto> itemDtoList = itemService.getItemsByUserId(userId);
        return ResponseEntity
                .ok()
                .body(itemDtoList);
    }


    @Operation(
            summary = "Update Item",
            description = "REST API call to update all fields apart from the item name and item id of an item"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP status OK"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP status INTERNAL SERVER ERROR",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
                    )
            }
    )
    @PutMapping("/update-item")
    public ResponseEntity<ResponseDto> updateItem(@Valid @RequestBody ItemDto itemDto) {
        itemService.update(itemDto);
        return ResponseEntity
                .ok()
                .body( new ResponseDto(ItemConstants.STATUS_200, ItemConstants.MESSAGE_200));
    }


    @Operation(
            summary = "Delete Item",
            description = "REST API call to remove an item from the database by their item name"
    )
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "HTTP status OK"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "HTTP status INTERNAL SERVER ERROR",
                            content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))
                    )
            }
    )
    @DeleteMapping("/delete-item")
    public ResponseEntity<ResponseDto> deleteItem(@NotBlank(message = "Please enter your name.")
                                                  @RequestParam
                                                  String itemName) {
        itemService.deleteItem(itemName);
        return ResponseEntity
                .ok()
                .body( new ResponseDto(ItemConstants.STATUS_200, ItemConstants.MESSAGE_200));
    }
}
