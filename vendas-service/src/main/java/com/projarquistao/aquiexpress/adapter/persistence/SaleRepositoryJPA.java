package com.projarquistao.aquiexpress.adapter.persistence;

import com.projarquistao.aquiexpress.business.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepositoryJPA extends JpaRepository<Sale, Long> {

}
