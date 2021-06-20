package com.projarquistao.estoque.business.repository;

import com.projarquistao.estoque.business.model.SaleItem;

import java.util.List;

public interface SaleItemRepository {
    void save(SaleItem sale);

    List<SaleItem> findAll();
}
