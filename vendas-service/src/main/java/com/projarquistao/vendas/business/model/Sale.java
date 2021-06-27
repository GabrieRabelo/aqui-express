package com.projarquistao.vendas.business.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sale", fetch = FetchType.EAGER, targetEntity = SaleItem.class)
    private List<SaleItem> saleItemList = new ArrayList<>();

    public Sale() {
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public List<SaleItem> getSaleItemList() {
        return saleItemList;
    }

    public Sale addSaleItem(SaleItem saleItem) {
        saleItem.setSale(this);
        this.saleItemList.add(saleItem);
        return this;
    }
}
