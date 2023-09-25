package com.aamir.inventory;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    private final ModelMapper modelMapper;

    public ItemMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ItemDto entityToDto(Item entity) {
        return modelMapper.map(entity, ItemDto.class);
    }

    public Item dtoToEntity(ItemDto entityDto) {
        return modelMapper.map(entityDto, Item.class);
    }
}
