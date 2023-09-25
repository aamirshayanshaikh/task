package com.aamir.inventorymanagmenttask.inventory;

import java.util.List;

public interface ItemService {

    ItemDto saveItem(ItemDto itemDto);
    ItemDto findItemById(Long id);
    List<ItemDto> findAllItems();

}
