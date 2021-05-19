package com.projarquistao.aquiexpress.adapter.persistence;

import com.projarquistao.aquiexpress.business.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepositoryJPA extends JpaRepository<InventoryItem, Long> {
}
