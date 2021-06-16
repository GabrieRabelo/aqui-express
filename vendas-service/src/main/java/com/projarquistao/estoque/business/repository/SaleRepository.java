package com.projarquistao.estoque.business.repository;

import com.projarquistao.estoque.business.model.Sale;

import java.util.List;

public interface SaleRepository {
    void save(Sale sale);
    List<Sale> findAll();
}
