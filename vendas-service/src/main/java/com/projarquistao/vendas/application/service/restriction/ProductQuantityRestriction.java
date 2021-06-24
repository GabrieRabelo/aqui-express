package com.projarquistao.vendas.application.service.restriction;

import com.projarquistao.vendas.business.model.SaleItem;
import com.projarquistao.vendas.business.service.IRestriction;

import java.util.List;

public class ProductQuantityRestriction implements IRestriction {
    private final int maxProductQuantity = 100;

    public boolean canSell(List<SaleItem> saleItemList) {
        return saleItemList
                .stream()
                .noneMatch(saleItem -> saleItem.getQuantity() > maxProductQuantity);
    }
}
