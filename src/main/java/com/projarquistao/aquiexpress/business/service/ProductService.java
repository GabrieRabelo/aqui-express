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

    public int calculateSubtotal(final List<SaleItem> itens) {

        var subtotal = 0;

        for (final SaleItem item : itens) {

            final var prod = productRepository.findById(item.getId());

            if (prod.isPresent()) {
                subtotal += (int) (prod.get().getPrice() * item.getQuantity());
            } else {
                throw new IllegalArgumentException("Codigo invalido");
            }

        }
        return subtotal;
    }
}
