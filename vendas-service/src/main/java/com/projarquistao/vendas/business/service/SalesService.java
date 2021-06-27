package com.projarquistao.vendas.business.service;

import com.projarquistao.vendas.business.model.Sale;
import com.projarquistao.vendas.business.model.SaleItem;
import com.projarquistao.vendas.business.repository.SaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SalesService.class);

    private final SaleRepository saleRepository;
    private final RestrictionFactory restrictionFactory;

    @Autowired
    public SalesService(SaleRepository saleRepository,
                        RestrictionFactory restrictionFactory) {
        this.saleRepository = saleRepository;
        this.restrictionFactory = restrictionFactory;
    }

    public void saveSale(List<SaleItem> saleItems) {

        var sale = new Sale();

        for (SaleItem saleItem: saleItems) {
            LOGGER.debug("Adding saleItem with id: {}", saleItem.getId());
            saleItem.setId(null);
            sale.addSaleItem(saleItem);
        }

        LOGGER.debug("Saving sale with id: {}", sale.getId());

        saleRepository.save(sale);

    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public boolean canSell(List<SaleItem> saleItems) {

        var restrictionInstance = restrictionFactory.getInstance();

        LOGGER.debug("Current restriction: {}", restrictionInstance.getClass());

        return restrictionInstance.canSell(saleItems);

    }

}
