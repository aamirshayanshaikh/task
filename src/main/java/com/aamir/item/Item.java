package com.aamir.item;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
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
    private Date itemEnteredDate;
    private Double	itemBuyingPrice;
    private Double itemSellingPrice;
    @UpdateTimestamp
    private Date itemLastModifiedDate;
    private String itemLastModifiedByUser;
    private String itemStatus;
    @Column(columnDefinition = "default 'AVAILABLE'")
    private String isItemAvailable;
}
