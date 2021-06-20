package com.projarquistao.estoque.adapter.persistence;

import com.projarquistao.estoque.business.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepositoryJPA extends JpaRepository<Sale, Long> {

}
