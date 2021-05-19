package com.projarquistao.aquiexpress.application.use_case;

import com.projarquistao.aquiexpress.business.model.InventoryItem;
import com.projarquistao.aquiexpress.business.service.InventoryItemService;
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
