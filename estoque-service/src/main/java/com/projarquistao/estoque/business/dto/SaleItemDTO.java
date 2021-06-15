package com.projarquistao.estoque.business.dto;

public class SaleItemDTO {
    private int quantity;
    private long productId;
    private float currentPrice;
    private float taxes;

    protected SaleItemDTO() {}


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