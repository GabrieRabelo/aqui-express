package com.projarquistao.estoque.adapter.persistence;

import com.projarquistao.estoque.business.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepositoryJPA extends JpaRepository<InventoryItem, Long> {
}
