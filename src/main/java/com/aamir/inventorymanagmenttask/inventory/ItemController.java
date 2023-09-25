package com.aamir.inventorymanagmenttask.inventory;

import com.aamir.inventorymanagmenttask.response.ResponseConstants;
import com.aamir.inventorymanagmenttask.response.ResponseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RequestMapping("app")
@RequiredArgsConstructor
@RestController
public class ItemController {

    private final ItemService itemService;

    @PostMapping("item")
    public ResponseEntity<Object> saveItem(@RequestBody ItemDto itemDto){

        if (itemDto.getItemId() != null){
            itemDto = itemService.findItemById(itemDto.getItemId());
            if (itemDto == null) {
                return ResponseHandler.response(
                        ResponseConstants.FAIL,
                        ResponseConstants.FAILURE_MESSAGE,
                        HttpStatus.BAD_REQUEST
                );
            }
        }

        return ResponseHandler.response(
                ResponseConstants.SUCCESS,
                itemDto,
                ResponseConstants.SUCCESS_MESSAGE,
                HttpStatus.OK
        );

    }

    @GetMapping("item")
    public ResponseEntity<Object> findAllItems(){
        return ResponseHandler.response(
                ResponseConstants.SUCCESS,
                itemService.findAllItems(),
                ResponseConstants.SUCCESS_MESSAGE,
                HttpStatus.OK
        );
    }


    @PutMapping("item")
    public ResponseEntity<Object> updateItem(){
        return ResponseHandler.response(
                ResponseConstants.SUCCESS,
                itemService.findAllItems(),
                ResponseConstants.SUCCESS_MESSAGE,
                HttpStatus.OK
        );
    }
}
