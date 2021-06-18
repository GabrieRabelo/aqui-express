package com.projarquistao.vendas.business.service;

import com.projarquistao.vendas.business.dto.SaleItemDTO;
import com.projarquistao.vendas.business.repository.InventoryItemRepository;
import com.projarquistao.vendas.business.model.InventoryItem;
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

    public boolean isAllAvailable(List<SaleItemDTO> saleItems) {

        for (SaleItemDTO saleItem : saleItems) {
            final var inventoryItem = inventoryItemRepository.findById(saleItem.getProductId());

            if (inventoryItem.isEmpty())
                return false;
        }

        return true;
    }

    public void withdrawInventory(List<SaleItemDTO> saleItems) {

        for (SaleItemDTO saleItem : saleItems) {
            final var inventoryItem = inventoryItemRepository.findById(saleItem.getProductId());

            if (inventoryItem.isPresent()){
                inventoryItem.get().subtractQuantity(saleItem.getQuantity());
                inventoryItemRepository.save(inventoryItem.get());
            }
        }
    }

}