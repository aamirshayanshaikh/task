package com.aamir.inventorymanagmenttask.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("app")
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @PostMapping("item")
    public List<Item> saveItem(@RequestBody ItemDto itemDto){
        return itemService.findAllItems();
    }

    @GetMapping("item")
    public List<Item> findAllItems(){
        return itemService.findAllItems();
    }
}
