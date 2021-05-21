package com.projarquistao.aquiexpress.business.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Sale {
    @Id
    private long id;
    private LocalDateTime date;

    @OneToMany
    private List<SaleItem> saleItemList;

    protected Sale() {}

    public Sale(List<SaleItem> saleItemList) {
        this.date = LocalDateTime.now();
        this.saleItemList = saleItemList;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
