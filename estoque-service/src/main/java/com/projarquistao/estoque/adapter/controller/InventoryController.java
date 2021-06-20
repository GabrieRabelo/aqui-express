package com.projarquistao.estoque.adapter.controller;

import com.projarquistao.estoque.application.use_case.*;
import com.projarquistao.estoque.business.dto.SaleItemDTO;
import com.projarquistao.estoque.business.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/estoque")
public class InventoryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);

    private final ListProductsUC listProductsUC;
    private final VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC;
    private final VerifySaleAvailabilityUC verifySaleAvailabilityUC;
    private final SubtotalUC subtotalUC;
    private final WithdrawInventoryUC withdrawInventoryUC;
    private final RollbackInventoryUC rollbackInventoryUC;

    @Autowired
    public InventoryController(ListProductsUC listProductsUC,
                               VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC,
                               VerifySaleAvailabilityUC verifySaleAvailabilityUC,
                               SubtotalUC subtotalUC, WithdrawInventoryUC withdrawInventoryUC,
                               RollbackInventoryUC rollbackInventoryUC) {
        this.listProductsUC = listProductsUC;
        this.verifyInventoryItemAvailabilityUC = verifyInventoryItemAvailabilityUC;
        this.verifySaleAvailabilityUC = verifySaleAvailabilityUC;
        this.subtotalUC = subtotalUC;
        this.withdrawInventoryUC = withdrawInventoryUC;
        this.rollbackInventoryUC = rollbackInventoryUC;
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

    @PostMapping("/baixa")
    public boolean baixarEstoque(@RequestBody final List<SaleItemDTO> saleItems) {
        LOGGER.debug("Withdrawing repository.");
        return withdrawInventoryUC.withdrawInventory(saleItems);
    }

    @PostMapping("/baixa/rollback")
    public boolean rollbackEstoque(@RequestBody final List<SaleItemDTO> saleItems) {
        LOGGER.debug("Withdrawing repository.");
        return rollbackInventoryUC.rollback(saleItems);
    }
}