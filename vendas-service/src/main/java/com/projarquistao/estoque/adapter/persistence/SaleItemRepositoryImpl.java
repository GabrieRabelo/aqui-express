package com.projarquistao.estoque.adapter.persistence;

import com.projarquistao.estoque.business.model.SaleItem;
import com.projarquistao.estoque.business.repository.SaleItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleItemRepositoryImpl implements SaleItemRepository {

    private final SaleItemRepositoryJPA saleItemRepositoryJPA;

    @Autowired
    public SaleItemRepositoryImpl(SaleItemRepositoryJPA saleItemRepositoryJPA) {
        this.saleItemRepositoryJPA = saleItemRepositoryJPA;
    }

    @Override
    public void save(SaleItem sale) {
        saleItemRepositoryJPA.save(sale);
    }

    @Override
    public List<SaleItem> findAll() {
        return saleItemRepositoryJPA.findAll();
    }
}