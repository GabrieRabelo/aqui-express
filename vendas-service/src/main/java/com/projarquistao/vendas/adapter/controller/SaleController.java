package com.projarquistao.vendas.adapter.controller;

import com.projarquistao.vendas.application.use_case.ConfirmSaleUC;
import com.projarquistao.vendas.application.use_case.HistoryUC;
import com.projarquistao.vendas.business.model.Sale;
import com.projarquistao.vendas.business.model.SaleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vendas")
public class SaleController {
    private final ConfirmSaleUC confirmSaleUC;
    private final HistoryUC historyUC;

    @Autowired
    public SaleController(ConfirmSaleUC confirmSaleUC, HistoryUC historyUC) {
        this.confirmSaleUC = confirmSaleUC;
        this.historyUC = historyUC;
    }

    @PostMapping("/confirmacao")
    public boolean confirmaVenda(@RequestBody final List<SaleItem> itens) {
        return confirmSaleUC.confirmSale(itens);
    }

    @GetMapping("/historico")
    public List<Sale> vendasEfetuadas() {
        return historyUC.findAllSales();
    }
}