package com.projarquistao.vendas.adapter.persistence;

import com.projarquistao.vendas.business.model.Product;
import com.projarquistao.vendas.business.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductRepositoryJPA productRepository;

    @Autowired
    public ProductRepositoryImpl(ProductRepositoryJPA productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
