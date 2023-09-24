package com.aamir.inventorymanagmenttask.inventory;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    public List<Item> findAllItems(){
        return itemRepository.findAll();
    }

    @Override
    public Item saveItem(ItemDto itemDto) {
        return itemRepository.save(Item.builder()
                .itemName(itemDto.getItemName())
                .itemBuyingPrice(itemDto.getItemBuyingPrice())
                .itemSellingPrice(itemDto.getItemSellingPrice())
                .itemEnteredByUser(itemDto.getItemEnteredByUser())
                .build());
    }
}
