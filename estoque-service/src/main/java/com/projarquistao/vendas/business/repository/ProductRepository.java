package com.projarquistao.vendas.business.repository;

import com.projarquistao.vendas.business.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
