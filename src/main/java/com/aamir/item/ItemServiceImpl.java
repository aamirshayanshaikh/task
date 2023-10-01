package com.aamir.item;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ItemServiceImpl implements ItemService{

    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;


    @Override
    public ItemDto saveItem(ItemDto itemDto) {
        return itemMapper.entityToDto(
                itemRepository.save(
                        Item.builder()
                                .itemId(itemDto.getItemId())
                                .itemSellingPrice(itemDto.getItemSellingPrice())
                                .itemBuyingPrice(itemDto.getItemBuyingPrice())
                                .itemName(itemDto.getItemName())
                                .itemLastModifiedDate(itemDto.getItemLastModifiedDate())
                                .build())
        );

    }

    @Override
    public Optional<Item> findItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }

    @Override
    public List<ItemDto> findAllItems(){
        return itemRepository.findAll().stream()
                .map(itemMapper::entityToDto)
                .collect(Collectors.toList());

    }


    @Override
    public List<ItemDto> findByItemStatusAndUser(String itemStatus, String itemEnteredByUser) {
        return itemRepository.findByItemStatusAndItemEnteredByUser(
                itemStatus,
                itemEnteredByUser
        ).stream().map(itemMapper::entityToDto).collect(Collectors.toList());
    }


    @Override
    public Page<Item> findAllItemsByPagination(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }
}
