package apm.ds.userservice.controller;

import apm.ds.userservice.constants.UserConstants;
import apm.ds.userservice.dto.*;
import apm.ds.userservice.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/users", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @Operation(
            summary = "Create User",
            description = "REST API call to create a user"
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
    @PostMapping("/create-user")
    public ResponseEntity<ResponseDto> createUser (@Valid @RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_201));
    }


    @Operation(
            summary = "Read User",
            description = "REST API call to get a user by their username"
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
    @GetMapping("/get-user")
    public ResponseEntity<UserInfoDto> getUser(@NotBlank(message = "Please enter your name.")
                                                @RequestParam
                                                String username) {

        UserInfoDto userInfoDto = userService.getUserInfoDto(username);
        return ResponseEntity
                .ok()
                .body(userInfoDto);
    }


    @Operation(
            summary = "Update User",
            description = "REST API call to update all fields apart from the ID and username of a user"
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
    @PutMapping("/update-user")
    public ResponseEntity<ResponseDto> updateUser(@Valid @RequestBody UserDto userDto) {
        userService.update(userDto);
        return ResponseEntity
                .ok()
                .body( new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200));
    }


    @Operation(
            summary = "Delete User",
            description = "REST API call to remove a user from the database by their username"
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
    @DeleteMapping("/delete-user")
    public ResponseEntity<ResponseDto> deleteUser(@NotBlank(message = "Please enter your name.")
                                                  @RequestParam
                                                  String username) {
        userService.deleteUser(username);
        return ResponseEntity
                .ok()
                .body( new ResponseDto(UserConstants.STATUS_200, UserConstants.MESSAGE_200));
    }

    @Operation(
            summary = "Delete User",
            description = "REST API call to remove a user from the database by their username"
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
    @GetMapping("/get-user-items")
    public ResponseEntity<UserItemsDto> getUserItems(@NotBlank(message = "Please enter your name.")
                                                     @RequestParam
                                                     String username) {

        UserItemsDto userItemsDto = userService.getUserItems(username);
        return ResponseEntity.
                ok()
                .body(userItemsDto);
    }

}
