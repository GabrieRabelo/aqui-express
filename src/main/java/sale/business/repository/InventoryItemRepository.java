package sale.business.repository;

import sale.business.model.InventoryItem;

import java.util.Optional;

public interface InventoryItemRepository {
    Optional<InventoryItem> findById(Long id);
    InventoryItem save(InventoryItem inventoryItem);
}
