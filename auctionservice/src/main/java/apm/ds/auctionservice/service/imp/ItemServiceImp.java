package apm.ds.auctionservice.service.imp;

import apm.ds.auctionservice.dto.ItemDto;
import apm.ds.auctionservice.entity.Item;
import apm.ds.auctionservice.exception.ItemAlreadyExistsException;
import apm.ds.auctionservice.exception.ResourceNotFoundException;
import apm.ds.auctionservice.mapper.ItemMapper;
import apm.ds.auctionservice.repository.ItemRepository;
import apm.ds.auctionservice.service.IItemService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ItemServiceImp implements IItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImp(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void createItem(ItemDto itemDto) {
        Optional<Item> userOptional = itemRepository.findByItemName(itemDto.getItemName());
        if (userOptional.isPresent()) {
            throw new ItemAlreadyExistsException(itemDto.getItemName());
        }

        Item item = ItemMapper.mapToEntity(itemDto, new Item());
        itemRepository.save(item);
    }

    @Override
    public ItemDto getItemDto(String itemName) {
        Optional<Item> userOptional = itemRepository.findByItemName(itemName);
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("Item", "item name", itemName);
        }
        return ItemMapper.mapToDto(userOptional.get(), new ItemDto());
    }

    @Override
    public void update(ItemDto itemDto) {
        Item itemToUpdate = itemRepository.findByItemName(itemDto.getItemName())
                .orElseThrow(() -> new ResourceNotFoundException("Item", "item name", itemDto.getItemName()));

        Item updatedItem = ItemMapper.mapToEntity(itemDto, itemToUpdate);
        itemRepository.save(updatedItem);
    }

    @Override
    @Transactional
    public void deleteItem(String itemName) {
        Optional<Item> userOptional = itemRepository.findByItemName(itemName);
        if (userOptional.isEmpty()) {
            throw new ResourceNotFoundException("Item", "item name", itemName);
        }

        itemRepository.removeUserByItemName(itemName);
    }
}
