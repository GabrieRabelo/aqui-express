package com.projarquistao.vendas.adapter.persistence;

import com.projarquistao.vendas.business.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepositoryJPA extends JpaRepository<SaleItem, Long> {

}