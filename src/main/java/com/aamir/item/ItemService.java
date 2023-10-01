package com.aamir.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ItemService {

    ItemDto saveItem(Item item);

    Optional<Item> findItemById(Long id);

    List<ItemDto> findAllItems();

    void deleteById(Long id);

    void deleteAll();

    List<ItemDto> findByItemStatusAndUser(String itemStatus,
                                          String itemEnteredByUser);


    Page<Item> findAllItemsByPagination(Pageable pageable);;

}
