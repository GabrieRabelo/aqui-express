package com.projarquistao.estoque.business.service;

import com.projarquistao.estoque.business.dto.SaleItemDTO;
import com.projarquistao.estoque.business.model.Product;
import com.projarquistao.estoque.business.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public boolean isAllAvailable(List<SaleItemDTO> saleItems) {

        LOGGER.debug("Verifying every sale item availability before selling");
        for (SaleItemDTO saleItem : saleItems) {
            final var productOptional = productRepository.findById(saleItem.getProductId());

            if (productOptional.isEmpty())
                return false;
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
