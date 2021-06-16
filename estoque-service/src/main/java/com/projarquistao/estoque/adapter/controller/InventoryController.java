package com.projarquistao.estoque.adapter.controller;

import com.projarquistao.estoque.application.use_case.*;
import com.projarquistao.estoque.business.dto.SaleItemDTO;
import com.projarquistao.estoque.business.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class InventoryController {
    private final ListProductsUC listProductsUC;
    private final VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC;
    private final SubtotalUC subtotalUC;

    @Autowired
    public InventoryController(ListProductsUC listProductsUC,
                               VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC,
                               SubtotalUC subtotalUC) {
        this.listProductsUC = listProductsUC;
        this.verifyInventoryItemAvailabilityUC = verifyInventoryItemAvailabilityUC;
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

    @PostMapping("/subtotal")
    @CrossOrigin(origins = "*")
    public int[] calculaSubtotal(@RequestBody final List<SaleItemDTO> itens) {
        return subtotalUC.calculaValores(itens);
    }
}