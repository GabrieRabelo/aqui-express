package com.projarquistao.estoque.adapter.persistence;

import com.projarquistao.estoque.business.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepositoryJPA extends JpaRepository<SaleItem, Long> {

}