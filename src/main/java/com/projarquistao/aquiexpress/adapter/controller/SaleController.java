package com.projarquistao.aquiexpress.adapter.controller;

import com.projarquistao.aquiexpress.application.use_case.ConfirmSaleUC;
import com.projarquistao.aquiexpress.application.use_case.ListProductsUC;
import com.projarquistao.aquiexpress.application.use_case.VerifyInventoryItemAvailabilityUC;
import com.projarquistao.aquiexpress.business.model.Product;
import com.projarquistao.aquiexpress.business.model.SaleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class SaleController {
    //    private final List<Product> produtos;
//    private final List<String> vendasEfetuadas;
    private final ListProductsUC listProductsUC;
    private final VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC;
    private final ConfirmSaleUC confirmSaleUC;

    @Autowired
    public SaleController(ListProductsUC listProductsUC,
                          VerifyInventoryItemAvailabilityUC verifyInventoryItemAvailabilityUC,
                          ConfirmSaleUC confirmSaleUC) {
        this.listProductsUC = listProductsUC;
        this.verifyInventoryItemAvailabilityUC = verifyInventoryItemAvailabilityUC;
        this.confirmSaleUC = confirmSaleUC;
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
        return confirmSaleUC.confimSale(itens);
    }
//
//    @GetMapping("/historico")
//    @CrossOrigin(origins = "*")
//    public List<String> vendasEfetuadas() {
//        return vendasEfetuadas;
//    }
//
//    @PostMapping("/subtotal")
//    @CrossOrigin(origins = "*")
//    public Integer[] calculaSubtotal(@RequestBody final SaleItem[] itens) {
//        Integer subtotal = 0;
//        Integer imposto = 0;
//
//        for (final SaleItem it : itens) {
//            // Procurar o produto pelo código
//            final Product prod =
//                    produtos.stream().filter(p -> p.getId() == it.getId()).findAny().orElse(null);
//
//            if (prod != null) {
//                subtotal += (int) (prod.getPrice() * it.getQuantity());
//            } else {
//                throw new IllegalArgumentException("Codigo invalido");
//            }
//        }
//        imposto = (int) (subtotal * 0.1);
//        final Integer[] resp = new Integer[3];
//        resp[0] = subtotal;
//        resp[1] = imposto;
//        resp[2] = subtotal + imposto;
//        return resp;
//    }
}