package com.projarquistao.vendas.business.service;

import com.projarquistao.vendas.business.model.Sale;
import com.projarquistao.vendas.business.model.SaleItem;
import com.projarquistao.vendas.business.repository.SaleItemRepository;
import com.projarquistao.vendas.business.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SaleRepository saleRepository;
    private final SaleItemRepository saleItemRepository;
    private final RestrictionFactory restrictionFactory;

    @Autowired
    public SalesService(SaleRepository saleRepository,
                        SaleItemRepository saleItemRepository, RestrictionFactory restrictionFactory) {
        this.saleRepository = saleRepository;
        this.saleItemRepository = saleItemRepository;
        this.restrictionFactory = restrictionFactory;
    }

    public void saveSale(List<SaleItem> saleItems) {

        var sale = new Sale();
        saleRepository.save(sale);
        sale = saleRepository.findById(sale.getId()).get();

        for (SaleItem saleItem : saleItems) {
            saleItem.setSale(sale);
            saleItemRepository.save(saleItem);
        }

        saleRepository.save(sale);

    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public boolean canSell(List<SaleItem> saleItems) {

        var restrictionInstance = restrictionFactory.getInstance();

        return restrictionInstance.canSell(saleItems);

    }

}
