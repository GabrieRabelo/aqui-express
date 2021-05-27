package com.projarquistao.aquiexpress.business.service;

import com.projarquistao.aquiexpress.business.model.InventoryItem;
import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.repository.InventoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InventoryItemService {

    private final InventoryItemRepository inventoryItemRepository;

    @Autowired
    public InventoryItemService(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public boolean isAvailable(long id, int quantity) {
        Optional<InventoryItem> inventoryItemOptional = inventoryItemRepository.findById(id);
        if (inventoryItemOptional.isEmpty())
            return false;
        return inventoryItemOptional.get().getAvailableQuantity() >= quantity;
    }

    public boolean isAllAvailable(List<SaleItem> saleItems) {

        for (SaleItem saleItem : saleItems) {
            final var inventoryItem = inventoryItemRepository.findById(saleItem.getProduct().getId());

            if (inventoryItem.isEmpty())
                return false;
        }

        return true;
    }

    public void withdrawInventory(List<SaleItem> saleItems) {

        for (SaleItem saleItem : saleItems) {
            final var inventoryItem = inventoryItemRepository.findById(saleItem.getProduct().getId());

            if (inventoryItem.isPresent()){
                inventoryItem.get().subtractQuantity(saleItem.getQuantity());
                inventoryItemRepository.save(inventoryItem.get());
            }
        }
    }

}
