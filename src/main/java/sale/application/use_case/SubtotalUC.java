package sale.application.use_case;

import sale.business.model.SaleItem;
import sale.business.service.ITaxCalculator;
import sale.business.service.ProductService;
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
