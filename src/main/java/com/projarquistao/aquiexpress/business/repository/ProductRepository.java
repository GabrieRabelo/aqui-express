package com.projarquistao.aquiexpress.business.repository;

import com.projarquistao.aquiexpress.business.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}
