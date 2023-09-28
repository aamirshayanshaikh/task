package com.aamir.item;

import com.aamir.response.ResponseConstants;
import com.aamir.response.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/app")
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;


    @PostMapping("item")
    public ResponseEntity<Object> saveItem(@RequestBody ItemDto itemDto) {

        if (itemDto.getItemId() != null) {
            Optional<Item> optionalItem = itemService.findItemById(itemDto.getItemId());
            if (!optionalItem.isPresent()) {
                return ResponseHandler.response(
                        ResponseConstants.FAIL,
                        ResponseConstants.FAILURE_MESSAGE,
                        HttpStatus.BAD_REQUEST
                );
            }
        }

        itemDto.setItemEnteredByUser("Aamir");
        itemDto.setItemLastModifiedByUser("Shayan");
        itemDto.setItemEnteredDate(new Date());
        itemDto.setIsItemAvailable(ItemStatus.AVAILABLE.getStatus());
        itemService.saveItem(itemDto);
        return ResponseHandler.response(
                ResponseConstants.SUCCESS,
                ResponseConstants.SUCCESS_MESSAGE,
                HttpStatus.CREATED
        );

    }

    @PutMapping("item/{itemId}")
    public ResponseEntity<Object> updateItem(@PathVariable Long itemId,
                                             @RequestBody ItemDto itemDto) {
        Optional<Item> optionalItem = itemService.findItemById(itemId);

        if (optionalItem.isPresent()) {

            Item item = optionalItem.get();
            itemDto.setItemId(item.getItemId());
            itemDto = itemService.saveItem(itemDto);

            return ResponseEntity.status(HttpStatus.OK).body(itemDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @DeleteMapping("item/{itemId}")
    public ResponseEntity<Object> updateItem(@PathVariable Long itemId) {
        Optional<Item> optionalItem = itemService.findItemById(itemId);

        if (optionalItem.isPresent()) {

            itemService.deleteById(itemId);

            return ResponseHandler.response(
                    ResponseConstants.SUCCESS,
                    ResponseConstants.SUCCESS_MESSAGE,
                    HttpStatus.OK
            );
        } else {
            return ResponseHandler.response(
                    ResponseConstants.FAIL,
                    itemService.findAllItems(),
                    ResponseConstants.FAILURE_MESSAGE,
                    HttpStatus.BAD_REQUEST
            );
        }

    }

    @DeleteMapping("item")
    public ResponseEntity<Object> deleteAll() {

        itemService.deleteAll();
        return ResponseHandler.response(
                ResponseConstants.SUCCESS,
                ResponseConstants.SUCCESS_MESSAGE,
                HttpStatus.OK
        );

    }

    @GetMapping("item/{itemId}")
    public ResponseEntity<Object> findById(@PathVariable Long itemId) {

        Optional<Item> item = itemService.findItemById(itemId);
        if (item.isPresent()) {
            return ResponseHandler.response(
                    ResponseConstants.SUCCESS,
                    item,
                    ResponseConstants.SUCCESS_MESSAGE,
                    HttpStatus.OK
            );
        } else {
            return ResponseHandler.response(
                    ResponseConstants.SUCCESS,
                    item,
                    ResponseConstants.SUCCESS_MESSAGE,
                    HttpStatus.NOT_FOUND
            );
        }

    }

    @GetMapping("/item")
    public ResponseEntity<Object> findAllItems() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(itemService.findAllItems());
    }


   /* @GetMapping("item")
    public ResponseEntity<Object> findByItemStatusAndUser(@RequestParam(name = "itemStatus") String itemStatus,
                                                          @RequestParam(name = "itemEnteredByUser") String itemEnteredByUser) {

        List<ItemDto> items = itemService.findByItemStatusAndUser(itemStatus, itemEnteredByUser);
        return ResponseHandler.response(
                ResponseConstants.SUCCESS,
                items,
                ResponseConstants.SUCCESS_MESSAGE,
                HttpStatus.OK
        );

    }*/


    @GetMapping("/items-by-pagination")
    public Page<Item> findAllItemsByPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "itemId") String sortBy) {

        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortBy));
        return itemService.findAllItemsByPagination(pageable);
    }

}
