package com.aamir.inventorymanagmenttask.inventory;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class ItemDto {

    private Long itemId;
    private String itemName;
    private String	itemEnteredByUser;
    private Timestamp itemEnteredDate;
    private Double	itemBuyingPrice;
    private Double itemSellingPrice;
    private Timestamp itemLastModifiedDate;
    private String itemLastModifiedByUser;
    private String itemStatus;
}
