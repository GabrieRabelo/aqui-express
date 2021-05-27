package com.projarquistao.aquiexpress.business.service;

import com.projarquistao.aquiexpress.business.model.Product;
import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public boolean isAllAvailable(List<SaleItem> saleItems) {

        for (SaleItem saleItem : saleItems) {
            final var productOptional = productRepository.findById(saleItem.getProduct().getId());

            if (productOptional.isEmpty())
                return false;

            saleItem.setCurrentPrice(productOptional.get().getPrice());
        }
        return true;
    }
}
