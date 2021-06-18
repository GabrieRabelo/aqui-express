package com.projarquistao.vendas.business.repository;

import com.projarquistao.vendas.business.model.Sale;

import java.util.List;

public interface SaleRepository {
    void save(Sale sale);
    List<Sale> findAll();
}
