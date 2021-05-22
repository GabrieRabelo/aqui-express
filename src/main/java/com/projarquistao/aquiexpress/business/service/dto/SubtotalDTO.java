package com.projarquistao.aquiexpress.business.service.dto;

public class SubtotalDTO {
    private int subtotal;
    private int tax;
    private int total;

    public SubtotalDTO(int subtotal, int tax) {
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = subtotal + tax;
    }
}
