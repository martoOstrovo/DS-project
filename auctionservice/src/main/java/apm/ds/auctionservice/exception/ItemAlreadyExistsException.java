package apm.ds.auctionservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ItemAlreadyExistsException extends RuntimeException {
    public ItemAlreadyExistsException(String itemName) {
        super(String.format("Item with item name: '%s' already exists", itemName));
    }
}
