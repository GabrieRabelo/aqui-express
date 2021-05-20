package com.projarquistao.aquiexpress.adapter.persistence;

import com.projarquistao.aquiexpress.business.model.Sale;
import com.projarquistao.aquiexpress.business.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SaleRepositoryImpl implements SaleRepository {

    private final SaleRepositoryJPA saleRepositoryJPA;

    @Autowired
    public SaleRepositoryImpl(SaleRepositoryJPA saleRepositoryJPA) {
        this.saleRepositoryJPA = saleRepositoryJPA;
    }

    @Override
    public void save(Sale sale) {
        saleRepositoryJPA.save(sale);
    }
}
