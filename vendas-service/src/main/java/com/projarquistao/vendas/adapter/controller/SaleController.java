package com.projarquistao.vendas.adapter.controller;

import com.projarquistao.vendas.application.use_case.ConfirmSaleUC;
import com.projarquistao.vendas.application.use_case.HistoryUC;
import com.projarquistao.vendas.business.model.Sale;
import com.projarquistao.vendas.business.model.SaleItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vendas")
public class SaleController {

    private final HistoryUC historyUC;

    @Autowired
    public SaleController(HistoryUC historyUC) {
        this.historyUC = historyUC;
    }

    @GetMapping("/historico")
    public List<Sale> vendasEfetuadas() {
        return historyUC.findAllSales();
    }
}