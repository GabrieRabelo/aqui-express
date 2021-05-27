package com.projarquistao.aquiexpress.application.use_case;

import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.service.ITaxCalculator;
import com.projarquistao.aquiexpress.business.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SubtotalUC {

    private final ProductService productService;
    private final ITaxCalculator taxCalculator;

    public SubtotalUC(ProductService productService,
                      ITaxCalculator taxCalculator) {
        this.productService = productService;
        this.taxCalculator = taxCalculator;
    }

    public int[] calculaValores(final List<SaleItem> itens) {

        var subtotal = productService.calculateSubtotal(itens);
        var imposto = (int) (subtotal * taxCalculator.calculateIVATaxPercentage(subtotal));

        return new int[]{subtotal, imposto, subtotal + imposto};
    }

}
