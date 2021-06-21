package com.projarquistao.vendas.application.use_case;

import com.projarquistao.vendas.business.model.Sale;
import com.projarquistao.vendas.business.service.SalesService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryUC {

    private final SalesService salesService;

    public HistoryUC(SalesService salesService) {
        this.salesService = salesService;
    }

    public List<Sale> findAllSales() {
        return salesService.findAllSales();
    }
}
