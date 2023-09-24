package com.aamir.inventorymanagmenttask.inventory;

import java.util.List;

public interface ItemService {

    Item saveItem(ItemDto itemDto);
    List<Item> findAllItems();

}
