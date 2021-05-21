package com.projarquistao.aquiexpress.business.repository;

import com.projarquistao.aquiexpress.business.model.InventoryItem;

import java.util.Optional;

public interface InventoryItemRepository {
    Optional<InventoryItem> findById(Long id);
    InventoryItem save(InventoryItem inventoryItem);
}
