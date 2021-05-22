package com.projarquistao.aquiexpress.adapter.controller;

import com.projarquistao.aquiexpress.business.service.dto.SubtotalDTO;
import com.projarquistao.aquiexpress.application.use_case.ConfirmSaleUC;
import com.projarquistao.aquiexpress.application.use_case.HistoryUC;
import com.projarquistao.aquiexpress.application.use_case.ListProductsUC;
import com.projarquistao.aquiexpress.application.use_case.SubtotalUC;
import com.projarquistao.aquiexpress.application.use_case.VerifyInventoryItemAvailabilityUC;
import com.projarquistao.aquiexpress.business.model.Product;
import com.projarquistao.aquiexpress.business.model.Sale;
import com.projarquistao.aquiexpress.business.model.SaleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class SaleController {
    private final ListProductsUC listProductsUC;
    private final VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC;
    private final ConfirmSaleUC confirmSaleUC;
    private final HistoryUC historyUC;
    private final SubtotalUC subtotalUC;

    @Autowired
    public SaleController(ListProductsUC listProductsUC,
                          VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC,
                          ConfirmSaleUC confirmSaleUC, HistoryUC historyUC, SubtotalUC subtotalUC) {
        this.listProductsUC = listProductsUC;
        this.verifyInventoryItemAvailabilityUC = verifyInventoryItemAvailabilityUC;
        this.confirmSaleUC = confirmSaleUC;
        this.historyUC = historyUC;
        this.subtotalUC = subtotalUC;
    }

    @GetMapping("/produtos")
    @CrossOrigin(origins = "*")
    public List<Product> listaProdutos() {
        return listProductsUC.findAll();
    }


    @GetMapping("/autorizacao")
    @CrossOrigin(origins = "*")
    public boolean podeVender(@RequestParam final Integer codProd,
                              @RequestParam final Integer qtdade) {
        return verifyInventoryItemAvailabilityUC.isAvailable(codProd, qtdade);
    }

    @PostMapping("/confirmacao")
    @CrossOrigin(origins = "*")
    public boolean confirmaVenda(@RequestBody final SaleItem[] itens) {
        return confirmSaleUC.confirmSale(itens);
    }

    @GetMapping("/historico")
    @CrossOrigin(origins = "*")
    public List<Sale> vendasEfetuadas() {
        return historyUC.findAllSales();
    }



    @PostMapping("/subtotal")
    @CrossOrigin(origins = "*")
    public SubtotalDTO calculaSubtotal(@RequestBody final SaleItem[] itens) {
        return subtotalUC.calculateSubtotal(itens);
    }
}