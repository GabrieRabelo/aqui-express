package com.projarquistao.estoque.business.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class InventoryItem {
    @Id
    private long id;
    private int availableQuantity;

    protected InventoryItem() {}

    public long getId() {
        return id;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void subtractQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        if (quantity > availableQuantity) {
            throw new IllegalArgumentException("Quantidade não pode ser maior que a quantidade disponível atual.");
        }
        availableQuantity -= quantity;
    }

    public void sumQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        availableQuantity += quantity;
    }
}
