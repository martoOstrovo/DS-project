package apm.ds.auctionservice.service;

import apm.ds.auctionservice.dto.ItemDto;

public interface IItemService {
    void createItem(ItemDto itemDto);

    ItemDto getItemDto(String itemName);

    void update(ItemDto itemDto);

    void deleteItem(String itemName);
}
