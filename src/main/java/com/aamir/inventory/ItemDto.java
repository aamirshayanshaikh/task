package com.aamir.inventory;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
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
    private String isItemAvailable;
}
