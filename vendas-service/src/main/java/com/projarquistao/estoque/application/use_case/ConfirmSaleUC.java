package com.projarquistao.estoque.application.use_case;

import com.projarquistao.estoque.business.model.SaleItem;
import com.projarquistao.estoque.business.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfirmSaleUC {

    private final SalesService salesService;

    @Autowired
    public ConfirmSaleUC(SalesService salesService) {
        this.salesService = salesService;
    }

    public boolean confirmSale(List<SaleItem> saleItem){
//        if(!canProceedSale(saleItem))
//            return false;

//        inventoryItemService.withdrawInventory(saleItem);
        salesService.finishSale(saleItem);

        return true;

    }

//    private boolean canProceedSale(List<SaleItem> saleItem) {
//        return productService.isAllAvailable(saleItem)
//                && inventoryItemService.isAllAvailable(saleItem)
//                && salesService.canSell(saleItem);
//    }
}
