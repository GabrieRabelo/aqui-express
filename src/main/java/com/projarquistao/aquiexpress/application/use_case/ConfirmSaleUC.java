package com.projarquistao.aquiexpress.application.use_case;

import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.service.InventoryItemService;
import com.projarquistao.aquiexpress.business.service.ProductService;
import com.projarquistao.aquiexpress.business.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfirmSaleUC {

    private final SalesService salesService;
    private final ProductService productService;
    private final InventoryItemService inventoryItemService;

    @Autowired
    public ConfirmSaleUC(SalesService salesService,
                         ProductService productService,
                         InventoryItemService inventoryItemService) {
        this.salesService = salesService;
        this.productService = productService;
        this.inventoryItemService = inventoryItemService;
    }

    public boolean confirmSale(List<SaleItem> saleItem){
        if(!canProceedSale(saleItem))
            return false;

        inventoryItemService.withdrawInventory(saleItem);
        salesService.finishSale(saleItem);

        return true;

    }

    private boolean canProceedSale(List<SaleItem> saleItem) {
        return productService.isAllAvailable(saleItem)
                && inventoryItemService.isAllAvailable(saleItem)
                && salesService.canSell(saleItem);
    }
}
