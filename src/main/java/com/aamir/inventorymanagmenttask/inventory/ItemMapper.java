package com.aamir.inventorymanagmenttask.inventory;

import org.mapstruct.Mapper;

@Mapper
public interface ItemMapper {
   /* @Mappings({
            @Mapping(target = "entityField1", source = "dtoField1"),
            @Mapping(target = "entityField2", source = "dtoField2")
            // Add more mappings as needed
    })*/
    Item dtoToEntity(ItemDto dto);

    ItemDto entityToDto(Item item);
}
