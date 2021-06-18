package com.projarquistao.vendas.adapter.persistence;

import com.projarquistao.vendas.business.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long> {
}
