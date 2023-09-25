package com.aamir.inventorymanagmenttask.inventory;



import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@NoArgsConstructor
@Builder
@Data
@Entity
public class Item {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
