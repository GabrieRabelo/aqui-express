package com.projarquistao.estoque.application.use_case;

import com.projarquistao.estoque.business.dto.SaleItemDTO;
import com.projarquistao.estoque.business.service.InventoryItemService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RollbackInventoryUC {

    private final InventoryItemService inventoryItemService;

    public RollbackInventoryUC(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    public boolean rollback(List<SaleItemDTO> items) {
        return inventoryItemService.rollbackInventory(items);
    }
}
