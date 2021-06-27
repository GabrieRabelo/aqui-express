package com.projarquistao.aplicacao.application.dtos;

public class ProductDTO {
    private Long id;
    private int quantity;

    private ProductDTO() {
    }

    public ProductDTO(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}