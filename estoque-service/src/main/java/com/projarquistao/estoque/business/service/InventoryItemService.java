package com.projarquistao.estoque.business.service;

import com.projarquistao.estoque.business.dto.SaleItemDTO;
import com.projarquistao.estoque.business.repository.InventoryItemRepository;
import com.projarquistao.estoque.business.dto.ProductDTO;
import com.projarquistao.estoque.business.model.InventoryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class InventoryItemService {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryItemService.class);

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

        LOGGER.debug("Checking if every inventory item is available.");
        for (SaleItemDTO saleItem : saleItems) {
            final var inventoryItem = inventoryItemRepository.findById(saleItem.getProductId());

            if (inventoryItem.isEmpty())
                return false;
        }

        return true;
    }

    public boolean withdrawInventory(List<SaleItemDTO> saleItems) {

        var toWithdraw = new ArrayList<SaleItemDTO>();

        LOGGER.debug("Withdrawing inventory");

        try{
            for (SaleItemDTO saleItem : saleItems) {
                final var inventoryItem = inventoryItemRepository.findById(saleItem.getProductId());

                if (inventoryItem.isPresent()) {
                    inventoryItem.get().subtractQuantity(saleItem.getQuantity());
                    toWithdraw.add(saleItem);
                    inventoryItemRepository.save(inventoryItem.get());
                } else {
                    LOGGER.error("Inventory for item with id {} is empty or inexistent", saleItem.getProductId());
                    throw new IllegalArgumentException("Produto não encontrado no estoque");
                }
            }

            return true;
        }catch (IllegalArgumentException e) {
            LOGGER.error("Rollbacking sale");
            this.rollbackInventory(toWithdraw);
            return false;
        }
    }

    public boolean addInventoryItems(List<ProductDTO> products) {

        var toAdd = new ArrayList<InventoryItem>();

        for (ProductDTO product : products) {
            final var inventoryItem = inventoryItemRepository.findById(product.getId());

            if (inventoryItem.isPresent()) {
                inventoryItem.get().sumQuantity(product.getQuantity());
                toAdd.add(inventoryItem.get());
            } else {
                return false;
            }
        }

        inventoryItemRepository.saveAll(toAdd);
        return true;
    }

    public boolean rollbackInventory(List<SaleItemDTO> saleItems) {

        var toRollback = new ArrayList<InventoryItem>();

        LOGGER.debug("Rollbacking inventory withdraw.");

        for (SaleItemDTO saleItem : saleItems) {
            final var inventoryItem = inventoryItemRepository.findById(saleItem.getProductId());

            if (inventoryItem.isPresent()) {
                inventoryItem.get().sumQuantity(saleItem.getQuantity());
                toRollback.add(inventoryItem.get());
            } else {
                return false;
            }
        }

        inventoryItemRepository.saveAll(toRollback);
        return true;
    }

}
