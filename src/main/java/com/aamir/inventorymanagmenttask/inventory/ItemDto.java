package com.aamir.inventorymanagmenttask.inventory;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Builder
@Data
public class ItemDto {

    private Integer itemId;
    private String itemName;
    private String	itemEnteredByUser;
    private Timestamp itemEnteredDate;
    private Double	itemBuyingPrice;
    private Double itemSellingPrice;
    private Timestamp itemLastModifiedDate;
    private String itemLastModifiedByUser;
    private String itemStatus;
}
