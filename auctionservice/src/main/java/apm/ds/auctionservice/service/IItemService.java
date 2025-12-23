package apm.ds.auctionservice.service;

import apm.ds.auctionservice.dto.ItemDto;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface IItemService {
    void createItem(ItemDto itemDto);

    ItemDto getItemDto(String itemName);

    void update(ItemDto itemDto);

    void deleteItem(String itemName);

    List<ItemDto> getItemsByUserId(@Positive(message = "user id must be a positive integer value") Long userId);
}
