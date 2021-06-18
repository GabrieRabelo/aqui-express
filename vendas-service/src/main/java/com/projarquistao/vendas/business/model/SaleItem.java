package com.projarquistao.vendas.business.model;

import javax.persistence.*;

@Entity
public class SaleItem {
    @Id
    private long id;
    private int quantity;
    private long productId;
    private float currentPrice;
    private float taxes;
    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    protected SaleItem() {}

    public long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public float getCurrentPrice() {
        return this.currentPrice;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }
}