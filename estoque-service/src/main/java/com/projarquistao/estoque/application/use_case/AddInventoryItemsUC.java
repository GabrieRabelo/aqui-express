package com.projarquistao.estoque.application.use_case;

import com.projarquistao.estoque.business.dto.ProductDTO;
import com.projarquistao.estoque.business.service.InventoryItemService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddInventoryItemsUC {
    private final InventoryItemService inventoryItemService;

    public AddInventoryItemsUC(InventoryItemService inventoryItemService) {
        this.inventoryItemService = inventoryItemService;
    }

    public boolean addInventoryItems(List<ProductDTO> products) {
        return inventoryItemService.addInventoryItems(products);
    }
}
