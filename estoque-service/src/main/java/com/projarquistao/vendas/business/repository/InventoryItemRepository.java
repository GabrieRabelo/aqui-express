package com.projarquistao.vendas.business.repository;

import com.projarquistao.vendas.business.model.InventoryItem;

import java.util.Optional;

public interface InventoryItemRepository {
    Optional<InventoryItem> findById(Long id);
    InventoryItem save(InventoryItem inventoryItem);
}
