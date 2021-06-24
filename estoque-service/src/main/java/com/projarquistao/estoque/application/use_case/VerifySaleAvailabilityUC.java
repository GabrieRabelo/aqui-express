package com.projarquistao.estoque.application.use_case;

import com.projarquistao.estoque.business.dto.SaleItemDTO;
import com.projarquistao.estoque.business.service.InventoryItemService;
import com.projarquistao.estoque.business.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VerifySaleAvailabilityUC {
    private ProductService productService;
    private InventoryItemService inventoryItemService;

    public VerifySaleAvailabilityUC(ProductService productService, InventoryItemService inventoryItemService) {
        this.productService = productService;
        this.inventoryItemService = inventoryItemService;
    }

    public boolean verifyAvailability(List<SaleItemDTO> saleItems) {
        return productService.isAllAvailable(saleItems)
                && inventoryItemService.isAllAvailable(saleItems);
    }
}
