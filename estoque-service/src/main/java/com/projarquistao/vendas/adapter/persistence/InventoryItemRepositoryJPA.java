package com.projarquistao.vendas.adapter.persistence;

import com.projarquistao.vendas.business.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepositoryJPA extends JpaRepository<InventoryItem, Long> {
}
