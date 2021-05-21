package com.projarquistao.aquiexpress.application.use_case;

import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmSaleUC {
    private final SalesService salesService;

    @Autowired
    public ConfirmSaleUC(SalesService salesService) {
        this.salesService = salesService;
    }

    public boolean confirmSale(SaleItem[] saleItem){
        return salesService.confirmSale(saleItem);
    }
}
