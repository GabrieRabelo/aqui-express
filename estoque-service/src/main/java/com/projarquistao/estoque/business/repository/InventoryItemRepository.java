package com.projarquistao.estoque.business.repository;

import com.projarquistao.estoque.business.model.InventoryItem;

import java.util.Optional;

public interface InventoryItemRepository {
    Optional<InventoryItem> findById(Long id);
    InventoryItem save(InventoryItem inventoryItem);
}
