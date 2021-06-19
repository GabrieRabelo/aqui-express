package com.projarquistao.vendas.adapter.controller;

import com.projarquistao.vendas.application.use_case.*;
import com.projarquistao.vendas.business.dto.SaleItemDTO;
import com.projarquistao.vendas.business.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estoque")
public class InventoryController {
    private final ListProductsUC listProductsUC;
    private final VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC;
    private final VerifySaleAvailabilityUC verifySaleAvailabilityUC;
    private final SubtotalUC subtotalUC;

    @Autowired
    public InventoryController(ListProductsUC listProductsUC,
                               VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC,
                               VerifySaleAvailabilityUC verifySaleAvailabilityUC,
                               SubtotalUC subtotalUC) {
        this.listProductsUC = listProductsUC;
        this.verifyInventoryItemAvailabilityUC = verifyInventoryItemAvailabilityUC;
        this.verifySaleAvailabilityUC = verifySaleAvailabilityUC;
        this.subtotalUC = subtotalUC;
    }

    @GetMapping("/produtos")
    public List<Product> listaProdutos() {
        return listProductsUC.findAll();
    }

    @GetMapping("/autorizacao")
    public boolean podeVender(@RequestParam final Integer codProd,
                              @RequestParam final Integer qtdade) {
        return verifyInventoryItemAvailabilityUC.isAvailable(codProd, qtdade);
    }

    @PostMapping("/subtotal")
    public int[] calculaSubtotal(@RequestBody final List<SaleItemDTO> itens) {
        return subtotalUC.calculaValores(itens);
    }

    @PostMapping("/produtos/disponibilidade")
    public boolean verificaDisponibilidade(@RequestBody final List<SaleItemDTO> saleItems) {
        return verifySaleAvailabilityUC.verifyAvailability(saleItems);
    }
}