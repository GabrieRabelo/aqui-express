package com.projarquistao.estoque.adapter.persistence;

import com.projarquistao.estoque.business.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long> {
}
