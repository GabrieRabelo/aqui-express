package com.projarquistao.aquiexpress.adapter.persistence;

import com.projarquistao.aquiexpress.business.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long> {
}
