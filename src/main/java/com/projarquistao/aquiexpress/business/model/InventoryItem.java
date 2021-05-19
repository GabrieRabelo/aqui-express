package com.projarquistao.aquiexpress.business.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class InventoryItem {
    @Id
    private long id;
    private int availableQuantity;

    protected InventoryItem() {
    }

    public long getId() {
        return id;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }
}
