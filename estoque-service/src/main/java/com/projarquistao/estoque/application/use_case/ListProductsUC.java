package com.projarquistao.estoque.application.use_case;

import com.projarquistao.estoque.business.model.Product;
import com.projarquistao.estoque.business.service.ProductService;
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
