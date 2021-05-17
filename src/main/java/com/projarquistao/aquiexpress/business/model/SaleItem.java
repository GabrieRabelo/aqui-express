package com.projarquistao.aquiexpress.business.model;

public class SaleItem {
    private long id;
    private int quantity;
    private Product product;
    private float taxes;

    public SaleItem(long id, int quantity, Product product, float taxes) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.taxes = taxes;
    }

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public float getTaxes() {
        return taxes;
    }
}