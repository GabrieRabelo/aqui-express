package com.projarquistao.aplicacao.application.dtos;

import java.util.StringJoiner;

public class SaleItemDTO {

    private Long id;
    private int quantity;
    private long productId;
    private float currentPrice;

    protected SaleItemDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SaleItemDTO.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("quantity=" + quantity)
                .add("productId=" + productId)
                .add("currentPrice=" + currentPrice)
                .toString();
    }
}