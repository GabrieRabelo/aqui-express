package com.projarquistao.vendas.business.repository;

import com.projarquistao.vendas.business.model.Sale;

import java.util.List;
import java.util.Optional;

public interface SaleRepository {
    void save(Sale sale);
    Optional<Sale> findById(Long id);
    List<Sale> findAll();
}
