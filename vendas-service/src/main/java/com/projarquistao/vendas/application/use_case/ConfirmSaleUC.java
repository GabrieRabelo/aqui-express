package com.projarquistao.vendas.application.use_case;

import com.projarquistao.vendas.adapter.client.InventoryClient;
import com.projarquistao.vendas.business.model.SaleItem;
import com.projarquistao.vendas.business.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfirmSaleUC {

    private final SalesService salesService;
    private final InventoryClient inventoryClient;

    @Autowired
    public ConfirmSaleUC(SalesService salesService, InventoryClient inventoryClient) {
        this.salesService = salesService;
        this.inventoryClient = inventoryClient;
    }

    public boolean confirmSale(List<SaleItem> saleItem){
        if(!canProceedSale(saleItem))
            return false;

//        inventoryItemService.withdrawInventory(saleItem);
        salesService.saveSale(saleItem);

        return true;
    }

    private boolean canProceedSale(List<SaleItem> saleItems) {
        return inventoryClient.verifyProductAvailability(saleItems)
                && salesService.canSell(saleItems);
    }
}
