package apm.ds.auctionservice.mapper;

import apm.ds.auctionservice.dto.ItemDto;
import apm.ds.auctionservice.entity.Item;

public class ItemMapper {
    public static Item mapToEntity(ItemDto itemDto, Item item) {
        item.setUserId(Long.valueOf(itemDto.getUserId()));
        item.setItemName(itemDto.getItemName());
        item.setDescription(itemDto.getDescription());
        item.setCurrentPrice(Double.parseDouble(itemDto.getCurrentPrice()));
        return item;
    }

    public static ItemDto mapToDto(Item item, ItemDto itemDto) {
        itemDto.setUserId(item.getUserId().toString());
        itemDto.setItemName(item.getItemName());
        itemDto.setDescription(item.getDescription());
        itemDto.setCurrentPrice(item.getCurrentPrice().toString());
        return itemDto;
    }
}
