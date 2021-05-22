package com.projarquistao.aquiexpress.application.use_case;

import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.service.SalesService;
import org.springframework.stereotype.Component;

@Component
public class SubtotalUC {

    private SalesService salesService;

    public SubtotalUC(SalesService salesService) {
        this.salesService = salesService;
    }

    public Integer[] calculateSubtotal(final SaleItem[] itens) {
        return salesService.calculateSubtotal(itens);
    }

}
