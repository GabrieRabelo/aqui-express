package com.projarquistao.vendas.application.use_case;

import com.projarquistao.vendas.business.model.Product;
import com.projarquistao.vendas.business.service.ProductService;
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
