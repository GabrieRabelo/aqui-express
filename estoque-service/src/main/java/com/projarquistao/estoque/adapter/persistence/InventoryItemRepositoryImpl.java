package com.projarquistao.estoque.adapter.persistence;

import com.projarquistao.estoque.business.model.InventoryItem;
import com.projarquistao.estoque.business.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InventoryItemRepositoryImpl implements InventoryItemRepository {

    private final InventoryItemRepositoryJPA inventoryItemRepositoryJPA;

    @Autowired
    public InventoryItemRepositoryImpl(InventoryItemRepositoryJPA inventoryItemRepositoryJPA) {
        this.inventoryItemRepositoryJPA = inventoryItemRepositoryJPA;
    }

    @Override
    public Optional<InventoryItem> findById(Long id) {
        return inventoryItemRepositoryJPA.findById(id);
    }

    @Override
    public InventoryItem save(InventoryItem inventoryItem) {
        return inventoryItemRepositoryJPA.save(inventoryItem);
    }

    @Override
    public void saveAll(List<InventoryItem> items) {
        this.inventoryItemRepositoryJPA.saveAll(items);
    }
}
