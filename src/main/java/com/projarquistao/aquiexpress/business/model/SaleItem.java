package com.projarquistao.aquiexpress.business.model;

import javax.persistence.*;

@Entity
public class SaleItem {
    @Id
    private long id;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
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

    public Product getProduct() {
        return product;
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