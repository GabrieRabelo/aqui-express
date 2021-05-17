package com.projarquistao.aquiexpress.business.model;

public class InventoryItem {
    private int availableQuantity;

    public InventoryItem(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }
}
