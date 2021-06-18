package com.projarquistao.vendas.application.use_case;

import com.projarquistao.vendas.business.service.InventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VerifyInventoryItemAvailabilityUC {

    private final InventoryItemService inventoryItemService;

    @Autowired
    public VerifyInventoryItemAvailabilityUC(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    public boolean isAvailable(long id, int quantity) {
        return inventoryItemService.isAvailable(id, quantity);
    }
}
