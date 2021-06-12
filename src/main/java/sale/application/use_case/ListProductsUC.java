package sale.application.use_case;

import sale.business.model.Product;
import sale.business.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListProductsUC {
    private final ProductService productService;

    @Autowired
    public ListProductsUC(ProductService productService) {
        this.productService = productService;
    }

    public List<Product> findAll() {
        return productService.findAll();
    }
}
