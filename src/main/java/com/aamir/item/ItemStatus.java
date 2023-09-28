package com.aamir.item;

import lombok.Getter;

@Getter
public enum ItemStatus {
    AVAILABLE("AVAILABLE", 1),
    SOLD("SOLD", 2);

    private final String status;
    private final int id;

    ItemStatus(String status, int id){
        this.status = status;
        this.id = id;
    }



}
