package com.projarquistao.vendas.business.service;

import com.projarquistao.vendas.business.dto.SaleItemDTO;
import com.projarquistao.vendas.business.model.Product;
import com.projarquistao.vendas.business.repository.ProductRepository;
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

    public boolean isAllAvailable(List<SaleItemDTO> saleItems) {

        for (SaleItemDTO saleItem : saleItems) {
            final var productOptional = productRepository.findById(saleItem.getProductId());

            if (productOptional.isEmpty())
                return false;

            saleItem.setCurrentPrice(productOptional.get().getPrice());
        }
        return true;
    }

    public int calculateSubtotal(final List<SaleItemDTO> itens) {

        var subtotal = 0;

        for (final SaleItemDTO item : itens) {

            final var prod = productRepository.findById(item.getProductId());

            if (prod.isPresent()) {
                subtotal += (int) (prod.get().getPrice() * item.getQuantity());
            } else {
                throw new IllegalArgumentException("Codigo invalido");
            }

        }
        return subtotal;
    }
}
