package com.projarquistao.vendas.business.repository;

import com.projarquistao.vendas.business.model.SaleItem;

import java.util.List;

public interface SaleItemRepository {
    void save(SaleItem sale);

    List<SaleItem> findAll();
}
