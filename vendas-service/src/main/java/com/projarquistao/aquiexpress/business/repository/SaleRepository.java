package com.projarquistao.aquiexpress.business.repository;

import com.projarquistao.aquiexpress.business.model.Sale;

import java.util.List;

public interface SaleRepository {
    void save(Sale sale);
    List<Sale> findAll();
}
