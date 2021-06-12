package com.projarquistao.aquiexpress.adapter.controller;

import com.projarquistao.aquiexpress.application.use_case.ConfirmSaleUC;
import com.projarquistao.aquiexpress.application.use_case.HistoryUC;
import com.projarquistao.aquiexpress.business.model.Sale;
import com.projarquistao.aquiexpress.business.model.SaleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    @CrossOrigin(origins = "*")
    public boolean confirmaVenda(@RequestBody final List<SaleItem> itens) {
        return confirmSaleUC.confirmSale(itens);
    }

    @GetMapping("/historico")
    @CrossOrigin(origins = "*")
    public List<Sale> vendasEfetuadas() {
        return historyUC.findAllSales();
    }
}