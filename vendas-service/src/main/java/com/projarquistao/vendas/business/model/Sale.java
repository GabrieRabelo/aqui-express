package com.projarquistao.vendas.business.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sale {
    @Id()
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private LocalDateTime date;

    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER)
    private List<SaleItem> saleItemList;

    protected Sale() {}

    public Sale(List<SaleItem> saleItemList) {
        this.date = LocalDateTime.now();
        this.saleItemList = saleItemList;
    }

    public long getId() {
        return id;
    }

    public List<SaleItem> getSaleItemList() {
        return this.saleItemList;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
