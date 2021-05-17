package com.projarquistao.aquiexpress.business.repository;

import com.projarquistao.aquiexpress.business.model.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> findAll();
}
