package com.projarquistao.vendas.adapter.persistence;

import com.projarquistao.vendas.business.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepositoryJPA extends JpaRepository<Sale, Long> {

}
