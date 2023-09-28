package com.aamir.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ItemDto {

    private Long itemId;
    private String itemName;
    private String	itemEnteredByUser;
    private Date itemEnteredDate;
    private Double	itemBuyingPrice;
    private Double itemSellingPrice;
    private Date  itemLastModifiedDate;
    private String itemLastModifiedByUser;
    private String isItemAvailable;
}
