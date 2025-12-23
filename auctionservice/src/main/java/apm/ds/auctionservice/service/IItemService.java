package apm.ds.auctionservice.service;

import apm.ds.auctionservice.dto.ItemDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public interface IItemService {
    void createItem(ItemDto itemDto);

    ItemDto getItemDto(String itemName);

    void update(ItemDto itemDto);

    void deleteItem(String itemName);
}
