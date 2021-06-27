package com.projarquistao.estoque.adapter.controller;

import com.projarquistao.estoque.application.use_case.AddInventoryItemsUC;
import com.projarquistao.estoque.application.use_case.ListProductsUC;
import com.projarquistao.estoque.application.use_case.RollbackInventoryUC;
import com.projarquistao.estoque.application.use_case.SubtotalUC;
import com.projarquistao.estoque.application.use_case.VerifyInventoryItemAvailabilityUC;
import com.projarquistao.estoque.application.use_case.VerifySaleAvailabilityUC;
import com.projarquistao.estoque.application.use_case.WithdrawInventoryUC;
import com.projarquistao.estoque.business.dto.ProductDTO;
import com.projarquistao.estoque.business.dto.SaleItemDTO;
import com.projarquistao.estoque.business.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private final AddInventoryItemsUC addInventoryItemsUC;

    @Autowired
    public InventoryController(ListProductsUC listProductsUC,
                               VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC,
                               VerifySaleAvailabilityUC verifySaleAvailabilityUC,
                               SubtotalUC subtotalUC, WithdrawInventoryUC withdrawInventoryUC,
                               RollbackInventoryUC rollbackInventoryUC,
                               AddInventoryItemsUC addInventoryItemsUC) {
        this.listProductsUC = listProductsUC;
        this.verifyInventoryItemAvailabilityUC = verifyInventoryItemAvailabilityUC;
        this.verifySaleAvailabilityUC = verifySaleAvailabilityUC;
        this.subtotalUC = subtotalUC;
        this.withdrawInventoryUC = withdrawInventoryUC;
        this.rollbackInventoryUC = rollbackInventoryUC;
        this.addInventoryItemsUC = addInventoryItemsUC;
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
        LOGGER.debug("Withdrawing inventory.");
        return withdrawInventoryUC.withdrawInventory(saleItems);
    }

    @PostMapping("/baixa/rollback")
    public boolean rollbackEstoque(@RequestBody final List<SaleItemDTO> saleItems) {
        LOGGER.debug("Rollbacking withdrawn inventory.");
        return rollbackInventoryUC.rollback(saleItems);
    }

}