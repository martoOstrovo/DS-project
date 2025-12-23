package apm.ds.auctionservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(name = "ErrorResponse", description = "Schema to hold error response information")
public class ErrorResponseDto {

    @Schema(description = "API path invoked by user")
    private String apiPath;

    @Schema(description = "Error response code")
    private HttpStatus errorCode;

    @Schema(description = "Error response message")
    private String errorMessage;

    @Schema(description = "Time at which error occurred")
    private LocalDateTime errorTime;

}
