package com.aamir.inventorymanagmenttask.inventory;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;


    @Override
    public ItemDto saveItem(ItemDto itemDto) {
        return itemMapper.entityToDto(
                itemRepository.save(itemMapper.dtoToEntity(itemDto))
        );
    }

    @Override
    public ItemDto findItemById(Long id) {
        return itemMapper.entityToDto(
                itemRepository.findById(id).get()
        );
    }

    public List<ItemDto> findAllItems(){
        return itemRepository.findAll().stream()
                .map(itemMapper::entityToDto)
                .collect(Collectors.toList());

    }
}
