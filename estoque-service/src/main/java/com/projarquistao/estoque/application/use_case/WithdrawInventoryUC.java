package com.projarquistao.estoque.application.use_case;

import com.projarquistao.estoque.business.dto.SaleItemDTO;
import com.projarquistao.estoque.business.service.InventoryItemService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WithdrawInventoryUC {

    private InventoryItemService inventoryItemService;

    public WithdrawInventoryUC(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    public boolean withdrawInventory(List<SaleItemDTO> saleItems) {
        return inventoryItemService.withdrawInventory(saleItems);
    }
}
